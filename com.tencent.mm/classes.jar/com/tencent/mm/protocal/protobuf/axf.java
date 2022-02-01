package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axf
  extends cvw
{
  public String FJg;
  public int FJh;
  public dw GOE;
  public String appId;
  public String cVJ;
  public String sign;
  public String tyK;
  public String tyL;
  public String tyM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32219);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appId != null) {
        paramVarArgs.d(2, this.appId);
      }
      if (this.tyK != null) {
        paramVarArgs.d(3, this.tyK);
      }
      if (this.tyL != null) {
        paramVarArgs.d(4, this.tyL);
      }
      if (this.tyM != null) {
        paramVarArgs.d(5, this.tyM);
      }
      if (this.cVJ != null) {
        paramVarArgs.d(6, this.cVJ);
      }
      if (this.sign != null) {
        paramVarArgs.d(7, this.sign);
      }
      if (this.GOE != null)
      {
        paramVarArgs.lJ(8, this.GOE.computeSize());
        this.GOE.writeFields(paramVarArgs);
      }
      if (this.FJg != null) {
        paramVarArgs.d(9, this.FJg);
      }
      paramVarArgs.aS(10, this.FJh);
      AppMethodBeat.o(32219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.appId);
      }
      i = paramInt;
      if (this.tyK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tyK);
      }
      paramInt = i;
      if (this.tyL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tyL);
      }
      i = paramInt;
      if (this.tyM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tyM);
      }
      paramInt = i;
      if (this.cVJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.cVJ);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.sign);
      }
      paramInt = i;
      if (this.GOE != null) {
        paramInt = i + f.a.a.a.lI(8, this.GOE.computeSize());
      }
      i = paramInt;
      if (this.FJg != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FJg);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.FJh);
      AppMethodBeat.o(32219);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32219);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axf localaxf = (axf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32219);
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
            localaxf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32219);
          return 0;
        case 2: 
          localaxf.appId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 3: 
          localaxf.tyK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 4: 
          localaxf.tyL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 5: 
          localaxf.tyM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 6: 
          localaxf.cVJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 7: 
          localaxf.sign = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxf.GOE = ((dw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32219);
          return 0;
        case 9: 
          localaxf.FJg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32219);
          return 0;
        }
        localaxf.FJh = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32219);
        return 0;
      }
      AppMethodBeat.o(32219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axf
 * JD-Core Version:    0.7.0.1
 */