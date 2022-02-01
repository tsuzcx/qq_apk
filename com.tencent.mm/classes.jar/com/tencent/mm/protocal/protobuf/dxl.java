package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxl
  extends com.tencent.mm.bx.a
{
  public String YFY;
  public String YIZ;
  public String abdc;
  public String abdd;
  public String abdn;
  public String abdp;
  public String abdq;
  public dxj abdt;
  public dxn abdv;
  public String app_id;
  public String hFb;
  public String nickname;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258232);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFY != null) {
        paramVarArgs.g(1, this.YFY);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.abdc != null) {
        paramVarArgs.g(3, this.abdc);
      }
      if (this.abdd != null) {
        paramVarArgs.g(4, this.abdd);
      }
      if (this.abdp != null) {
        paramVarArgs.g(5, this.abdp);
      }
      if (this.abdq != null) {
        paramVarArgs.g(6, this.abdq);
      }
      if (this.app_id != null) {
        paramVarArgs.g(7, this.app_id);
      }
      if (this.abdn != null) {
        paramVarArgs.g(8, this.abdn);
      }
      paramVarArgs.bS(9, this.source);
      if (this.abdt != null)
      {
        paramVarArgs.qD(10, this.abdt.computeSize());
        this.abdt.writeFields(paramVarArgs);
      }
      if (this.hFb != null) {
        paramVarArgs.g(11, this.hFb);
      }
      if (this.abdv != null)
      {
        paramVarArgs.qD(12, this.abdv.computeSize());
        this.abdv.writeFields(paramVarArgs);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(13, this.YIZ);
      }
      AppMethodBeat.o(258232);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YFY == null) {
        break label1078;
      }
    }
    label1078:
    for (int i = i.a.a.b.b.a.h(1, this.YFY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.abdc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abdc);
      }
      paramInt = i;
      if (this.abdd != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abdd);
      }
      i = paramInt;
      if (this.abdp != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abdp);
      }
      paramInt = i;
      if (this.abdq != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abdq);
      }
      i = paramInt;
      if (this.app_id != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.app_id);
      }
      paramInt = i;
      if (this.abdn != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abdn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.source);
      paramInt = i;
      if (this.abdt != null) {
        paramInt = i + i.a.a.a.qC(10, this.abdt.computeSize());
      }
      i = paramInt;
      if (this.hFb != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.hFb);
      }
      paramInt = i;
      if (this.abdv != null) {
        paramInt = i + i.a.a.a.qC(12, this.abdv.computeSize());
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.YIZ);
      }
      AppMethodBeat.o(258232);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258232);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dxl localdxl = (dxl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258232);
          return -1;
        case 1: 
          localdxl.YFY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258232);
          return 0;
        case 2: 
          localdxl.nickname = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258232);
          return 0;
        case 3: 
          localdxl.abdc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258232);
          return 0;
        case 4: 
          localdxl.abdd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258232);
          return 0;
        case 5: 
          localdxl.abdp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258232);
          return 0;
        case 6: 
          localdxl.abdq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258232);
          return 0;
        case 7: 
          localdxl.app_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258232);
          return 0;
        case 8: 
          localdxl.abdn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258232);
          return 0;
        case 9: 
          localdxl.source = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258232);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dxj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dxj)localObject2).parseFrom((byte[])localObject1);
            }
            localdxl.abdt = ((dxj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258232);
          return 0;
        case 11: 
          localdxl.hFb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258232);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dxn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dxn)localObject2).parseFrom((byte[])localObject1);
            }
            localdxl.abdv = ((dxn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258232);
          return 0;
        }
        localdxl.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258232);
        return 0;
      }
      AppMethodBeat.o(258232);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxl
 * JD-Core Version:    0.7.0.1
 */