package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class fxr
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public int aahW;
  public fxe aahY;
  public aex abVq;
  public va abVr;
  public eo abVs;
  public alj abVt;
  public String id;
  public int status;
  public int type;
  public int update_time;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258031);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      paramVarArgs.bS(2, this.type);
      paramVarArgs.bS(3, this.aahW);
      if (this.abVq != null)
      {
        paramVarArgs.qD(4, this.abVq.computeSize());
        this.abVq.writeFields(paramVarArgs);
      }
      if (this.abVr != null)
      {
        paramVarArgs.qD(5, this.abVr.computeSize());
        this.abVr.writeFields(paramVarArgs);
      }
      if (this.abVs != null)
      {
        paramVarArgs.qD(6, this.abVs.computeSize());
        this.abVs.writeFields(paramVarArgs);
      }
      if (this.abVt != null)
      {
        paramVarArgs.qD(7, this.abVt.computeSize());
        this.abVt.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.HTK);
      paramVarArgs.bS(9, this.update_time);
      paramVarArgs.bS(10, this.status);
      if (this.aahY != null)
      {
        paramVarArgs.qD(11, this.aahY.computeSize());
        this.aahY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258031);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1100;
      }
    }
    label1100:
    for (paramInt = i.a.a.b.b.a.h(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type) + i.a.a.b.b.a.cJ(3, this.aahW);
      paramInt = i;
      if (this.abVq != null) {
        paramInt = i + i.a.a.a.qC(4, this.abVq.computeSize());
      }
      i = paramInt;
      if (this.abVr != null) {
        i = paramInt + i.a.a.a.qC(5, this.abVr.computeSize());
      }
      paramInt = i;
      if (this.abVs != null) {
        paramInt = i + i.a.a.a.qC(6, this.abVs.computeSize());
      }
      i = paramInt;
      if (this.abVt != null) {
        i = paramInt + i.a.a.a.qC(7, this.abVt.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(8, this.HTK) + i.a.a.b.b.a.cJ(9, this.update_time) + i.a.a.b.b.a.cJ(10, this.status);
      paramInt = i;
      if (this.aahY != null) {
        paramInt = i + i.a.a.a.qC(11, this.aahY.computeSize());
      }
      AppMethodBeat.o(258031);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258031);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fxr localfxr = (fxr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258031);
          return -1;
        case 1: 
          localfxr.id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258031);
          return 0;
        case 2: 
          localfxr.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258031);
          return 0;
        case 3: 
          localfxr.aahW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258031);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aex();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aex)localObject2).parseFrom((byte[])localObject1);
            }
            localfxr.abVq = ((aex)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258031);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new va();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((va)localObject2).parseFrom((byte[])localObject1);
            }
            localfxr.abVr = ((va)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258031);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eo)localObject2).parseFrom((byte[])localObject1);
            }
            localfxr.abVs = ((eo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258031);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new alj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((alj)localObject2).parseFrom((byte[])localObject1);
            }
            localfxr.abVt = ((alj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258031);
          return 0;
        case 8: 
          localfxr.HTK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258031);
          return 0;
        case 9: 
          localfxr.update_time = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258031);
          return 0;
        case 10: 
          localfxr.status = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258031);
          return 0;
        }
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
          localfxr.aahY = ((fxe)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258031);
        return 0;
      }
      AppMethodBeat.o(258031);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxr
 * JD-Core Version:    0.7.0.1
 */