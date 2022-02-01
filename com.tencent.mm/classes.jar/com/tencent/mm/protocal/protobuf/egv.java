package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class egv
  extends com.tencent.mm.bw.a
{
  public String IiE;
  public int IkA;
  public String IkF;
  public egn IkG;
  public egu IkH;
  public int Ikz;
  public String Md5;
  public String ucL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110863);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IkF == null)
      {
        paramVarArgs = new b("Not all required fields were included: EntranceDomain");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.IiE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.IkF != null) {
        paramVarArgs.d(4, this.IkF);
      }
      if (this.IiE != null) {
        paramVarArgs.d(12, this.IiE);
      }
      if (this.IkG != null)
      {
        paramVarArgs.lJ(9, this.IkG.computeSize());
        this.IkG.writeFields(paramVarArgs);
      }
      if (this.IkH != null)
      {
        paramVarArgs.lJ(10, this.IkH.computeSize());
        this.IkH.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(5, this.Md5);
      }
      if (this.ucL != null) {
        paramVarArgs.d(6, this.ucL);
      }
      paramVarArgs.aS(7, this.Ikz);
      paramVarArgs.aS(8, this.IkA);
      AppMethodBeat.o(110863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IkF == null) {
        break label906;
      }
    }
    label906:
    for (int i = f.a.a.b.b.a.e(4, this.IkF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IiE != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.IiE);
      }
      i = paramInt;
      if (this.IkG != null) {
        i = paramInt + f.a.a.a.lI(9, this.IkG.computeSize());
      }
      paramInt = i;
      if (this.IkH != null) {
        paramInt = i + f.a.a.a.lI(10, this.IkH.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Md5);
      }
      paramInt = i;
      if (this.ucL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ucL);
      }
      i = f.a.a.b.b.a.bz(7, this.Ikz);
      int j = f.a.a.b.b.a.bz(8, this.IkA);
      AppMethodBeat.o(110863);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.IkF == null)
        {
          paramVarArgs = new b("Not all required fields were included: EntranceDomain");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        if (this.IiE == null)
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
        egv localegv = (egv)paramVarArgs[1];
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
          localegv.IkF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 12: 
          localegv.IiE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localegv.IkG = ((egn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localegv.IkH = ((egu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 5: 
          localegv.Md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 6: 
          localegv.ucL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 7: 
          localegv.Ikz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(110863);
          return 0;
        }
        localegv.IkA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(110863);
        return 0;
      }
      AppMethodBeat.o(110863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egv
 * JD-Core Version:    0.7.0.1
 */