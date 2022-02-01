package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dti
  extends cvw
{
  public String GwG;
  public String GwH;
  public String GwI;
  public boolean HYW;
  public LinkedList<String> HYX;
  public String HYY;
  public boolean HZb;
  public String MD5;
  public int Scene;
  
  public dti()
  {
    AppMethodBeat.i(104842);
    this.HYX = new LinkedList();
    AppMethodBeat.o(104842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104843);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(2, this.MD5);
      }
      paramVarArgs.bC(3, this.HZb);
      paramVarArgs.bC(4, this.HYW);
      paramVarArgs.e(5, 1, this.HYX);
      if (this.GwG != null) {
        paramVarArgs.d(6, this.GwG);
      }
      if (this.HYY != null) {
        paramVarArgs.d(7, this.HYY);
      }
      if (this.GwI != null) {
        paramVarArgs.d(8, this.GwI);
      }
      if (this.GwH != null) {
        paramVarArgs.d(9, this.GwH);
      }
      paramVarArgs.aS(10, this.Scene);
      AppMethodBeat.o(104843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.MD5);
      }
      i = i + f.a.a.b.b.a.amF(3) + f.a.a.b.b.a.amF(4) + f.a.a.a.c(5, 1, this.HYX);
      paramInt = i;
      if (this.GwG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GwG);
      }
      i = paramInt;
      if (this.HYY != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HYY);
      }
      paramInt = i;
      if (this.GwI != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GwI);
      }
      i = paramInt;
      if (this.GwH != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GwH);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.Scene);
      AppMethodBeat.o(104843);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HYX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dti localdti = (dti)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104843);
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
            localdti.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104843);
          return 0;
        case 2: 
          localdti.MD5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 3: 
          localdti.HZb = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(104843);
          return 0;
        case 4: 
          localdti.HYW = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(104843);
          return 0;
        case 5: 
          localdti.HYX.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(104843);
          return 0;
        case 6: 
          localdti.GwG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 7: 
          localdti.HYY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 8: 
          localdti.GwI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 9: 
          localdti.GwH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104843);
          return 0;
        }
        localdti.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104843);
        return 0;
      }
      AppMethodBeat.o(104843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dti
 * JD-Core Version:    0.7.0.1
 */