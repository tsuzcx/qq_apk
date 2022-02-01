package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azd
  extends cvw
{
  public String GiJ;
  public long GiW;
  public int GjL;
  public double latitude;
  public double longitude;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114015);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GiJ != null) {
        paramVarArgs.d(2, this.GiJ);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      paramVarArgs.aZ(5, this.GiW);
      paramVarArgs.aS(6, this.GjL);
      paramVarArgs.aS(7, this.scene);
      AppMethodBeat.o(114015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GiJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GiJ);
      }
      paramInt = f.a.a.b.b.a.amD(3);
      int j = f.a.a.b.b.a.amD(4);
      int k = f.a.a.b.b.a.p(5, this.GiW);
      int m = f.a.a.b.b.a.bz(6, this.GjL);
      int n = f.a.a.b.b.a.bz(7, this.scene);
      AppMethodBeat.o(114015);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114015);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azd localazd = (azd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114015);
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
            localazd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114015);
          return 0;
        case 2: 
          localazd.GiJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114015);
          return 0;
        case 3: 
          localazd.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(114015);
          return 0;
        case 4: 
          localazd.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(114015);
          return 0;
        case 5: 
          localazd.GiW = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(114015);
          return 0;
        case 6: 
          localazd.GjL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114015);
          return 0;
        }
        localazd.scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(114015);
        return 0;
      }
      AppMethodBeat.o(114015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azd
 * JD-Core Version:    0.7.0.1
 */