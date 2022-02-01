package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgp
  extends erp
{
  public long ZcJ;
  public String Zcw;
  public int Zdy;
  public double latitude;
  public double longitude;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114015);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Zcw != null) {
        paramVarArgs.g(2, this.Zcw);
      }
      paramVarArgs.d(3, this.latitude);
      paramVarArgs.d(4, this.longitude);
      paramVarArgs.bv(5, this.ZcJ);
      paramVarArgs.bS(6, this.Zdy);
      paramVarArgs.bS(7, this.scene);
      AppMethodBeat.o(114015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zcw != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Zcw);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      int j = i.a.a.b.b.a.ko(4);
      int k = i.a.a.b.b.a.q(5, this.ZcJ);
      int m = i.a.a.b.b.a.cJ(6, this.Zdy);
      int n = i.a.a.b.b.a.cJ(7, this.scene);
      AppMethodBeat.o(114015);
      return i + (paramInt + 8) + (j + 8) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114015);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cgp localcgp = (cgp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114015);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localcgp.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(114015);
          return 0;
        case 2: 
          localcgp.Zcw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114015);
          return 0;
        case 3: 
          localcgp.latitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(114015);
          return 0;
        case 4: 
          localcgp.longitude = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(114015);
          return 0;
        case 5: 
          localcgp.ZcJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(114015);
          return 0;
        case 6: 
          localcgp.Zdy = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114015);
          return 0;
        }
        localcgp.scene = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(114015);
        return 0;
      }
      AppMethodBeat.o(114015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgp
 * JD-Core Version:    0.7.0.1
 */