package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dlo
  extends erp
{
  public long NII;
  public int aaRE;
  public LinkedList<b> aaRF;
  public long aaRG;
  public long aaRH;
  public float latitude;
  public float longitude;
  
  public dlo()
  {
    AppMethodBeat.i(169918);
    this.aaRF = new LinkedList();
    AppMethodBeat.o(169918);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169919);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaRE);
      paramVarArgs.l(3, this.latitude);
      paramVarArgs.l(4, this.longitude);
      paramVarArgs.e(5, 6, this.aaRF);
      paramVarArgs.bv(6, this.NII);
      paramVarArgs.bv(7, this.aaRG);
      paramVarArgs.bv(8, this.aaRH);
      AppMethodBeat.o(169919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aaRE);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.a.c(5, 6, this.aaRF);
      int n = i.a.a.b.b.a.q(6, this.NII);
      int i1 = i.a.a.b.b.a.q(7, this.aaRG);
      int i2 = i.a.a.b.b.a.q(8, this.aaRH);
      AppMethodBeat.o(169919);
      return paramInt + i + (j + 4) + (k + 4) + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaRF.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dlo localdlo = (dlo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169919);
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
            localdlo.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(169919);
          return 0;
        case 2: 
          localdlo.aaRE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169919);
          return 0;
        case 3: 
          localdlo.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(169919);
          return 0;
        case 4: 
          localdlo.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(169919);
          return 0;
        case 5: 
          localdlo.aaRF.add(((i.a.a.a.a)localObject).ajGk.kFX());
          AppMethodBeat.o(169919);
          return 0;
        case 6: 
          localdlo.NII = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(169919);
          return 0;
        case 7: 
          localdlo.aaRG = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(169919);
          return 0;
        }
        localdlo.aaRH = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(169919);
        return 0;
      }
      AppMethodBeat.o(169919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlo
 * JD-Core Version:    0.7.0.1
 */