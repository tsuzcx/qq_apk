package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fau
  extends erp
{
  public String abAO;
  public float latitude;
  public float longitude;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32438);
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
      paramVarArgs.bS(4, this.scene);
      if (this.abAO != null) {
        paramVarArgs.g(5, this.abAO);
      }
      AppMethodBeat.o(32438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label485;
      }
    }
    label485:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 4) + (i.a.a.b.b.a.ko(3) + 4) + i.a.a.b.b.a.cJ(4, this.scene);
      paramInt = i;
      if (this.abAO != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abAO);
      }
      AppMethodBeat.o(32438);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fau localfau = (fau)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32438);
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
            localfau.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32438);
          return 0;
        case 2: 
          localfau.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(32438);
          return 0;
        case 3: 
          localfau.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(32438);
          return 0;
        case 4: 
          localfau.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32438);
          return 0;
        }
        localfau.abAO = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32438);
        return 0;
      }
      AppMethodBeat.o(32438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fau
 * JD-Core Version:    0.7.0.1
 */