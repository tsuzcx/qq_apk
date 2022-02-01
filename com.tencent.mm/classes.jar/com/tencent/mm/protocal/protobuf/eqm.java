package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class eqm
  extends erp
{
  public float abuk;
  public b abul;
  public boolean abum;
  public boolean abun;
  public String iaI;
  public float latitude;
  public float longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114064);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.l(2, this.longitude);
      paramVarArgs.l(3, this.latitude);
      paramVarArgs.l(4, this.abuk);
      if (this.abul != null) {
        paramVarArgs.d(5, this.abul);
      }
      if (this.iaI != null) {
        paramVarArgs.g(6, this.iaI);
      }
      paramVarArgs.di(7, this.abum);
      paramVarArgs.di(8, this.abun);
      AppMethodBeat.o(114064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label629;
      }
    }
    label629:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 4) + (i.a.a.b.b.a.ko(3) + 4) + (i.a.a.b.b.a.ko(4) + 4);
      paramInt = i;
      if (this.abul != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.abul);
      }
      i = paramInt;
      if (this.iaI != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.iaI);
      }
      paramInt = i.a.a.b.b.a.ko(7);
      int j = i.a.a.b.b.a.ko(8);
      AppMethodBeat.o(114064);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eqm localeqm = (eqm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114064);
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
            localeqm.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(114064);
          return 0;
        case 2: 
          localeqm.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(114064);
          return 0;
        case 3: 
          localeqm.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(114064);
          return 0;
        case 4: 
          localeqm.abuk = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(114064);
          return 0;
        case 5: 
          localeqm.abul = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(114064);
          return 0;
        case 6: 
          localeqm.iaI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114064);
          return 0;
        case 7: 
          localeqm.abum = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(114064);
          return 0;
        }
        localeqm.abun = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(114064);
        return 0;
      }
      AppMethodBeat.o(114064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqm
 * JD-Core Version:    0.7.0.1
 */