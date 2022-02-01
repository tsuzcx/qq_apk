package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class byy
  extends com.tencent.mm.bx.a
{
  public int ZmT;
  public int aahW;
  public int aahX;
  public fxe aahY;
  public String aahZ;
  public ewu aaia;
  public String id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257801);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      paramVarArgs.bS(2, this.type);
      paramVarArgs.bS(3, this.aahW);
      paramVarArgs.bS(4, this.ZmT);
      paramVarArgs.bS(5, this.aahX);
      if (this.aahY != null)
      {
        paramVarArgs.qD(6, this.aahY.computeSize());
        this.aahY.writeFields(paramVarArgs);
      }
      if (this.aahZ != null) {
        paramVarArgs.g(7, this.aahZ);
      }
      if (this.aaia != null)
      {
        paramVarArgs.qD(8, this.aaia.computeSize());
        this.aaia.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label714;
      }
    }
    label714:
    for (paramInt = i.a.a.b.b.a.h(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type) + i.a.a.b.b.a.cJ(3, this.aahW) + i.a.a.b.b.a.cJ(4, this.ZmT) + i.a.a.b.b.a.cJ(5, this.aahX);
      paramInt = i;
      if (this.aahY != null) {
        paramInt = i + i.a.a.a.qC(6, this.aahY.computeSize());
      }
      i = paramInt;
      if (this.aahZ != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aahZ);
      }
      paramInt = i;
      if (this.aaia != null) {
        paramInt = i + i.a.a.a.qC(8, this.aaia.computeSize());
      }
      AppMethodBeat.o(257801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257801);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        byy localbyy = (byy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257801);
          return -1;
        case 1: 
          localbyy.id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257801);
          return 0;
        case 2: 
          localbyy.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257801);
          return 0;
        case 3: 
          localbyy.aahW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257801);
          return 0;
        case 4: 
          localbyy.ZmT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257801);
          return 0;
        case 5: 
          localbyy.aahX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257801);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxe)localObject2).parseFrom((byte[])localObject1);
            }
            localbyy.aahY = ((fxe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257801);
          return 0;
        case 7: 
          localbyy.aahZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257801);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ewu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ewu)localObject2).parseFrom((byte[])localObject1);
          }
          localbyy.aaia = ((ewu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257801);
        return 0;
      }
      AppMethodBeat.o(257801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byy
 * JD-Core Version:    0.7.0.1
 */