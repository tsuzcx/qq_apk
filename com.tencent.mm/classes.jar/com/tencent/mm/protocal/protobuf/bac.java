package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bac
  extends erp
{
  public String EIo;
  public String EMd;
  public atz YIY;
  public float latitude;
  public float longitude;
  public String object_nonce_id;
  public int scene;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260223);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      paramVarArgs.l(3, this.longitude);
      paramVarArgs.l(4, this.latitude);
      paramVarArgs.bS(5, this.scene);
      if (this.EIo != null) {
        paramVarArgs.g(6, this.EIo);
      }
      if (this.title != null) {
        paramVarArgs.g(7, this.title);
      }
      if (this.EMd != null) {
        paramVarArgs.g(8, this.EMd);
      }
      if (this.object_nonce_id != null) {
        paramVarArgs.g(9, this.object_nonce_id);
      }
      AppMethodBeat.o(260223);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label796;
      }
    }
    label796:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YIY != null) {
        i = paramInt + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = i + (i.a.a.b.b.a.ko(3) + 4) + (i.a.a.b.b.a.ko(4) + 4) + i.a.a.b.b.a.cJ(5, this.scene);
      paramInt = i;
      if (this.EIo != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.EIo);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.title);
      }
      paramInt = i;
      if (this.EMd != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.EMd);
      }
      i = paramInt;
      if (this.object_nonce_id != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.object_nonce_id);
      }
      AppMethodBeat.o(260223);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260223);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bac localbac = (bac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260223);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbac.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260223);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbac.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260223);
          return 0;
        case 3: 
          localbac.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(260223);
          return 0;
        case 4: 
          localbac.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(260223);
          return 0;
        case 5: 
          localbac.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260223);
          return 0;
        case 6: 
          localbac.EIo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260223);
          return 0;
        case 7: 
          localbac.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260223);
          return 0;
        case 8: 
          localbac.EMd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260223);
          return 0;
        }
        localbac.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260223);
        return 0;
      }
      AppMethodBeat.o(260223);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bac
 * JD-Core Version:    0.7.0.1
 */