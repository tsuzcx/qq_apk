package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pn
  extends cvw
{
  public int FJf;
  public String FJg;
  public String FZa;
  public bwl Gdd;
  public cxz Gde;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32149);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FZa != null) {
        paramVarArgs.d(2, this.FZa);
      }
      if (this.Gdd != null)
      {
        paramVarArgs.lJ(3, this.Gdd.computeSize());
        this.Gdd.writeFields(paramVarArgs);
      }
      if (this.Gde != null)
      {
        paramVarArgs.lJ(4, this.Gde.computeSize());
        this.Gde.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.FJf);
      if (this.FJg != null) {
        paramVarArgs.d(6, this.FJg);
      }
      AppMethodBeat.o(32149);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FZa != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FZa);
      }
      i = paramInt;
      if (this.Gdd != null) {
        i = paramInt + f.a.a.a.lI(3, this.Gdd.computeSize());
      }
      paramInt = i;
      if (this.Gde != null) {
        paramInt = i + f.a.a.a.lI(4, this.Gde.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FJf);
      paramInt = i;
      if (this.FJg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FJg);
      }
      AppMethodBeat.o(32149);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32149);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pn localpn = (pn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32149);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpn.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 2: 
          localpn.FZa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32149);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpn.Gdd = ((bwl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpn.Gde = ((cxz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 5: 
          localpn.FJf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32149);
          return 0;
        }
        localpn.FJg = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32149);
        return 0;
      }
      AppMethodBeat.o(32149);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pn
 * JD-Core Version:    0.7.0.1
 */