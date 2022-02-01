package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtl
  extends com.tencent.mm.bx.a
{
  public String EGf;
  public int EHZ;
  public int EIa;
  public String EIf;
  public dtd EIg;
  public dtk EIh;
  public String Md5;
  public String rNA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110863);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EIf == null)
      {
        paramVarArgs = new b("Not all required fields were included: EntranceDomain");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.EGf == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.EIf != null) {
        paramVarArgs.d(4, this.EIf);
      }
      if (this.EGf != null) {
        paramVarArgs.d(12, this.EGf);
      }
      if (this.EIg != null)
      {
        paramVarArgs.kX(9, this.EIg.computeSize());
        this.EIg.writeFields(paramVarArgs);
      }
      if (this.EIh != null)
      {
        paramVarArgs.kX(10, this.EIh.computeSize());
        this.EIh.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(5, this.Md5);
      }
      if (this.rNA != null) {
        paramVarArgs.d(6, this.rNA);
      }
      paramVarArgs.aR(7, this.EHZ);
      paramVarArgs.aR(8, this.EIa);
      AppMethodBeat.o(110863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EIf == null) {
        break label906;
      }
    }
    label906:
    for (int i = f.a.a.b.b.a.e(4, this.EIf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EGf != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.EGf);
      }
      i = paramInt;
      if (this.EIg != null) {
        i = paramInt + f.a.a.a.kW(9, this.EIg.computeSize());
      }
      paramInt = i;
      if (this.EIh != null) {
        paramInt = i + f.a.a.a.kW(10, this.EIh.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Md5);
      }
      paramInt = i;
      if (this.rNA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.rNA);
      }
      i = f.a.a.b.b.a.bA(7, this.EHZ);
      int j = f.a.a.b.b.a.bA(8, this.EIa);
      AppMethodBeat.o(110863);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EIf == null)
        {
          paramVarArgs = new b("Not all required fields were included: EntranceDomain");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        if (this.EGf == null)
        {
          paramVarArgs = new b("Not all required fields were included: Charset");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110863);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtl localdtl = (dtl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(110863);
          return -1;
        case 4: 
          localdtl.EIf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 12: 
          localdtl.EGf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtl.EIg = ((dtd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtl.EIh = ((dtk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 5: 
          localdtl.Md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 6: 
          localdtl.rNA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 7: 
          localdtl.EHZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(110863);
          return 0;
        }
        localdtl.EIa = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(110863);
        return 0;
      }
      AppMethodBeat.o(110863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtl
 * JD-Core Version:    0.7.0.1
 */