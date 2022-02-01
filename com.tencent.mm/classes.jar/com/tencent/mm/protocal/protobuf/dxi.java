package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxi
  extends com.tencent.mm.bx.a
{
  public long NlD;
  public String YFT;
  public String YIZ;
  public String abdc;
  public String abdd;
  public String abdn;
  public String abdp;
  public String abdq;
  public String abdr;
  public String abds;
  public dxj abdt;
  public String app_id;
  public String nickname;
  public String psp;
  public String remark;
  public int sex;
  public int source;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152638);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.psp != null) {
        paramVarArgs.g(1, this.psp);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      paramVarArgs.bS(3, this.type);
      if (this.remark != null) {
        paramVarArgs.g(4, this.remark);
      }
      if (this.abdc != null) {
        paramVarArgs.g(5, this.abdc);
      }
      if (this.abdd != null) {
        paramVarArgs.g(6, this.abdd);
      }
      paramVarArgs.bS(7, this.source);
      if (this.abdp != null) {
        paramVarArgs.g(8, this.abdp);
      }
      if (this.abdq != null) {
        paramVarArgs.g(9, this.abdq);
      }
      if (this.abdr != null) {
        paramVarArgs.g(10, this.abdr);
      }
      if (this.abds != null) {
        paramVarArgs.g(11, this.abds);
      }
      if (this.abdt != null)
      {
        paramVarArgs.qD(12, this.abdt.computeSize());
        this.abdt.writeFields(paramVarArgs);
      }
      if (this.YFT != null) {
        paramVarArgs.g(13, this.YFT);
      }
      if (this.app_id != null) {
        paramVarArgs.g(14, this.app_id);
      }
      paramVarArgs.bS(15, this.sex);
      if (this.abdn != null) {
        paramVarArgs.g(16, this.abdn);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(17, this.YIZ);
      }
      paramVarArgs.bv(18, this.NlD);
      AppMethodBeat.o(152638);
      return 0;
    }
    if (paramInt == 1) {
      if (this.psp == null) {
        break label1268;
      }
    }
    label1268:
    for (paramInt = i.a.a.b.b.a.h(1, this.psp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nickname);
      }
      i += i.a.a.b.b.a.cJ(3, this.type);
      paramInt = i;
      if (this.remark != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.remark);
      }
      i = paramInt;
      if (this.abdc != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abdc);
      }
      paramInt = i;
      if (this.abdd != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abdd);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.source);
      paramInt = i;
      if (this.abdp != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abdp);
      }
      i = paramInt;
      if (this.abdq != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.abdq);
      }
      paramInt = i;
      if (this.abdr != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.abdr);
      }
      i = paramInt;
      if (this.abds != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.abds);
      }
      paramInt = i;
      if (this.abdt != null) {
        paramInt = i + i.a.a.a.qC(12, this.abdt.computeSize());
      }
      i = paramInt;
      if (this.YFT != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.YFT);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.app_id);
      }
      i = paramInt + i.a.a.b.b.a.cJ(15, this.sex);
      paramInt = i;
      if (this.abdn != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.abdn);
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.YIZ);
      }
      paramInt = i.a.a.b.b.a.q(18, this.NlD);
      AppMethodBeat.o(152638);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152638);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dxi localdxi = (dxi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152638);
          return -1;
        case 1: 
          localdxi.psp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 2: 
          localdxi.nickname = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 3: 
          localdxi.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152638);
          return 0;
        case 4: 
          localdxi.remark = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 5: 
          localdxi.abdc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 6: 
          localdxi.abdd = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 7: 
          localdxi.source = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152638);
          return 0;
        case 8: 
          localdxi.abdp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 9: 
          localdxi.abdq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 10: 
          localdxi.abdr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 11: 
          localdxi.abds = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dxj localdxj = new dxj();
            if ((localObject != null) && (localObject.length > 0)) {
              localdxj.parseFrom((byte[])localObject);
            }
            localdxi.abdt = localdxj;
            paramInt += 1;
          }
          AppMethodBeat.o(152638);
          return 0;
        case 13: 
          localdxi.YFT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 14: 
          localdxi.app_id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 15: 
          localdxi.sex = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152638);
          return 0;
        case 16: 
          localdxi.abdn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 17: 
          localdxi.YIZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152638);
          return 0;
        }
        localdxi.NlD = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(152638);
        return 0;
      }
      AppMethodBeat.o(152638);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxi
 * JD-Core Version:    0.7.0.1
 */