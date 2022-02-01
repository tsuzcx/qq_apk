package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bxt
  extends cvw
{
  public int Hkw;
  public LinkedList<b> Hkx;
  public long Hky;
  public long Hkz;
  public float dBu;
  public float dzE;
  public long xPa;
  
  public bxt()
  {
    AppMethodBeat.i(169918);
    this.Hkx = new LinkedList();
    AppMethodBeat.o(169918);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169919);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hkw);
      paramVarArgs.y(3, this.dzE);
      paramVarArgs.y(4, this.dBu);
      paramVarArgs.e(5, 6, this.Hkx);
      paramVarArgs.aZ(6, this.xPa);
      paramVarArgs.aZ(7, this.Hky);
      paramVarArgs.aZ(8, this.Hkz);
      AppMethodBeat.o(169919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Hkw);
      int j = f.a.a.b.b.a.amE(3);
      int k = f.a.a.b.b.a.amE(4);
      int m = f.a.a.a.c(5, 6, this.Hkx);
      int n = f.a.a.b.b.a.p(6, this.xPa);
      int i1 = f.a.a.b.b.a.p(7, this.Hky);
      int i2 = f.a.a.b.b.a.p(8, this.Hkz);
      AppMethodBeat.o(169919);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hkx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxt localbxt = (bxt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169919);
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
            localbxt.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169919);
          return 0;
        case 2: 
          localbxt.Hkw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169919);
          return 0;
        case 3: 
          localbxt.dzE = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(169919);
          return 0;
        case 4: 
          localbxt.dBu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(169919);
          return 0;
        case 5: 
          localbxt.Hkx.add(((f.a.a.a.a)localObject1).OmT.gCk());
          AppMethodBeat.o(169919);
          return 0;
        case 6: 
          localbxt.xPa = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169919);
          return 0;
        case 7: 
          localbxt.Hky = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169919);
          return 0;
        }
        localbxt.Hkz = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(169919);
        return 0;
      }
      AppMethodBeat.o(169919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxt
 * JD-Core Version:    0.7.0.1
 */