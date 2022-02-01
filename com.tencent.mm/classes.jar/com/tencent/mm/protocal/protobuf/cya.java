package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cya
  extends ckq
{
  public String CzY;
  public cxy Eqf;
  public cxy Eqg;
  public int Eqh;
  public int Eqi;
  public String gKn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eqf == null)
      {
        paramVarArgs = new b("Not all required fields were included: CommentDetail");
        AppMethodBeat.o(118439);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gKn != null) {
        paramVarArgs.d(2, this.gKn);
      }
      if (this.Eqf != null)
      {
        paramVarArgs.kX(3, this.Eqf.computeSize());
        this.Eqf.writeFields(paramVarArgs);
      }
      if (this.Eqg != null)
      {
        paramVarArgs.kX(6, this.Eqg.computeSize());
        this.Eqg.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.Eqh);
      paramVarArgs.aR(5, this.Eqi);
      if (this.CzY != null) {
        paramVarArgs.d(7, this.CzY);
      }
      AppMethodBeat.o(118439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gKn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gKn);
      }
      i = paramInt;
      if (this.Eqf != null) {
        i = paramInt + f.a.a.a.kW(3, this.Eqf.computeSize());
      }
      paramInt = i;
      if (this.Eqg != null) {
        paramInt = i + f.a.a.a.kW(6, this.Eqg.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Eqh) + f.a.a.b.b.a.bA(5, this.Eqi);
      paramInt = i;
      if (this.CzY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CzY);
      }
      AppMethodBeat.o(118439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Eqf == null)
        {
          paramVarArgs = new b("Not all required fields were included: CommentDetail");
          AppMethodBeat.o(118439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cya localcya = (cya)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118439);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcya.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 2: 
          localcya.gKn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118439);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcya.Eqf = ((cxy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcya.Eqg = ((cxy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 4: 
          localcya.Eqh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118439);
          return 0;
        case 5: 
          localcya.Eqi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118439);
          return 0;
        }
        localcya.CzY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(118439);
        return 0;
      }
      AppMethodBeat.o(118439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cya
 * JD-Core Version:    0.7.0.1
 */