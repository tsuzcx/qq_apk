package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class awd
  extends erp
{
  public atz CJv;
  public b ZGX;
  public avl ZGY;
  public int ZGZ;
  public int ZHa;
  public avl ZHb;
  public int ZHc;
  public String nVs;
  public String nickname;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168948);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.ZGX != null) {
        paramVarArgs.d(3, this.ZGX);
      }
      if (this.nVs != null) {
        paramVarArgs.g(4, this.nVs);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(5, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      if (this.signature != null) {
        paramVarArgs.g(6, this.signature);
      }
      if (this.ZGY != null)
      {
        paramVarArgs.qD(7, this.ZGY.computeSize());
        this.ZGY.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.ZGZ);
      paramVarArgs.bS(9, this.ZHa);
      if (this.ZHb != null)
      {
        paramVarArgs.qD(10, this.ZHb.computeSize());
        this.ZHb.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.ZHc);
      AppMethodBeat.o(168948);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1062;
      }
    }
    label1062:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.ZGX != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZGX);
      }
      paramInt = i;
      if (this.nVs != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nVs);
      }
      i = paramInt;
      if (this.CJv != null) {
        i = paramInt + i.a.a.a.qC(5, this.CJv.computeSize());
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.signature);
      }
      i = paramInt;
      if (this.ZGY != null) {
        i = paramInt + i.a.a.a.qC(7, this.ZGY.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(8, this.ZGZ) + i.a.a.b.b.a.cJ(9, this.ZHa);
      paramInt = i;
      if (this.ZHb != null) {
        paramInt = i + i.a.a.a.qC(10, this.ZHb.computeSize());
      }
      i = i.a.a.b.b.a.cJ(11, this.ZHc);
      AppMethodBeat.o(168948);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168948);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        awd localawd = (awd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168948);
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
            localawd.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 2: 
          localawd.nickname = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 3: 
          localawd.ZGX = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168948);
          return 0;
        case 4: 
          localawd.nVs = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 5: 
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
            localawd.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 6: 
          localawd.signature = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avl)localObject2).parseFrom((byte[])localObject1);
            }
            localawd.ZGY = ((avl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 8: 
          localawd.ZGZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168948);
          return 0;
        case 9: 
          localawd.ZHa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168948);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avl)localObject2).parseFrom((byte[])localObject1);
            }
            localawd.ZHb = ((avl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        }
        localawd.ZHc = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168948);
        return 0;
      }
      AppMethodBeat.o(168948);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awd
 * JD-Core Version:    0.7.0.1
 */