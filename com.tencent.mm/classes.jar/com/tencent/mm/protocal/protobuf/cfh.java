package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfh
  extends cvw
{
  public String DgJ;
  public String FVJ;
  public String FVK;
  public boolean HrU;
  public String HrV;
  public String HrW;
  public int HrX;
  public String HrY;
  public int dDd;
  public int dJd;
  public String dlT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72530);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FVJ != null) {
        paramVarArgs.d(2, this.FVJ);
      }
      if (this.FVK != null) {
        paramVarArgs.d(3, this.FVK);
      }
      if (this.HrV != null) {
        paramVarArgs.d(4, this.HrV);
      }
      if (this.HrW != null) {
        paramVarArgs.d(5, this.HrW);
      }
      if (this.DgJ != null) {
        paramVarArgs.d(6, this.DgJ);
      }
      if (this.dlT != null) {
        paramVarArgs.d(7, this.dlT);
      }
      paramVarArgs.aS(8, this.dDd);
      paramVarArgs.aS(9, this.HrX);
      paramVarArgs.bC(10, this.HrU);
      paramVarArgs.aS(11, this.dJd);
      if (this.HrY != null) {
        paramVarArgs.d(12, this.HrY);
      }
      AppMethodBeat.o(72530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label910;
      }
    }
    label910:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FVJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FVJ);
      }
      i = paramInt;
      if (this.FVK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVK);
      }
      paramInt = i;
      if (this.HrV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HrV);
      }
      i = paramInt;
      if (this.HrW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HrW);
      }
      paramInt = i;
      if (this.DgJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DgJ);
      }
      i = paramInt;
      if (this.dlT != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dlT);
      }
      i = i + f.a.a.b.b.a.bz(8, this.dDd) + f.a.a.b.b.a.bz(9, this.HrX) + f.a.a.b.b.a.amF(10) + f.a.a.b.b.a.bz(11, this.dJd);
      paramInt = i;
      if (this.HrY != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HrY);
      }
      AppMethodBeat.o(72530);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72530);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfh localcfh = (cfh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72530);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72530);
          return 0;
        case 2: 
          localcfh.FVJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 3: 
          localcfh.FVK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 4: 
          localcfh.HrV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 5: 
          localcfh.HrW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 6: 
          localcfh.DgJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 7: 
          localcfh.dlT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 8: 
          localcfh.dDd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72530);
          return 0;
        case 9: 
          localcfh.HrX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72530);
          return 0;
        case 10: 
          localcfh.HrU = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(72530);
          return 0;
        case 11: 
          localcfh.dJd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72530);
          return 0;
        }
        localcfh.HrY = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72530);
        return 0;
      }
      AppMethodBeat.o(72530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfh
 * JD-Core Version:    0.7.0.1
 */