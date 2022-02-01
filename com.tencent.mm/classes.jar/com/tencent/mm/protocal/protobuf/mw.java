package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mw
  extends cpx
{
  public LinkedList<String> Ecd;
  public String Ece;
  public double Ecf;
  public double Ecg;
  public String ProductID;
  public int Scene;
  
  public mw()
  {
    AppMethodBeat.i(124427);
    this.Ecd = new LinkedList();
    AppMethodBeat.o(124427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(2, this.ProductID);
      }
      paramVarArgs.e(3, 1, this.Ecd);
      paramVarArgs.aR(4, this.Scene);
      if (this.Ece != null) {
        paramVarArgs.d(5, this.Ece);
      }
      paramVarArgs.e(6, this.Ecf);
      paramVarArgs.e(7, this.Ecg);
      AppMethodBeat.o(124428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label628;
      }
    }
    label628:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ProductID);
      }
      i = i + f.a.a.a.c(3, 1, this.Ecd) + f.a.a.b.b.a.bx(4, this.Scene);
      paramInt = i;
      if (this.Ece != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ece);
      }
      i = f.a.a.b.b.a.fK(6);
      int j = f.a.a.b.b.a.fK(7);
      AppMethodBeat.o(124428);
      return paramInt + (i + 8) + (j + 8);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ecd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mw localmw = (mw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124428);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmw.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124428);
          return 0;
        case 2: 
          localmw.ProductID = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 3: 
          localmw.Ecd.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(124428);
          return 0;
        case 4: 
          localmw.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124428);
          return 0;
        case 5: 
          localmw.Ece = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 6: 
          localmw.Ecf = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(124428);
          return 0;
        }
        localmw.Ecg = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
        AppMethodBeat.o(124428);
        return 0;
      }
      AppMethodBeat.o(124428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mw
 * JD-Core Version:    0.7.0.1
 */