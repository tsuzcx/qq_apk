package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvo
  extends com.tencent.mm.bx.a
{
  public int ZUG;
  public String ZbX;
  public String aadf;
  public int aadg;
  public long aadh;
  public long aadi;
  public bzc aadj;
  public long aadk;
  public int aadl;
  public int aadm;
  public String aadn;
  public int aado;
  public aff aadp;
  public String aadq;
  public String mdE;
  public int type;
  public String wul;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258863);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aadf != null) {
        paramVarArgs.g(1, this.aadf);
      }
      if (this.mdE != null) {
        paramVarArgs.g(2, this.mdE);
      }
      paramVarArgs.bS(3, this.type);
      paramVarArgs.bS(4, this.ZUG);
      paramVarArgs.bS(5, this.aadg);
      if (this.wul != null) {
        paramVarArgs.g(6, this.wul);
      }
      paramVarArgs.bv(7, this.aadh);
      paramVarArgs.bv(8, this.aadi);
      if (this.ZbX != null) {
        paramVarArgs.g(9, this.ZbX);
      }
      if (this.aadj != null)
      {
        paramVarArgs.qD(10, this.aadj.computeSize());
        this.aadj.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(11, this.aadk);
      paramVarArgs.bS(12, this.aadl);
      paramVarArgs.bS(13, this.aadm);
      if (this.aadn != null) {
        paramVarArgs.g(14, this.aadn);
      }
      paramVarArgs.bS(15, this.aado);
      if (this.aadp != null)
      {
        paramVarArgs.qD(16, this.aadp.computeSize());
        this.aadp.writeFields(paramVarArgs);
      }
      if (this.aadq != null) {
        paramVarArgs.g(19, this.aadq);
      }
      AppMethodBeat.o(258863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aadf == null) {
        break label1194;
      }
    }
    label1194:
    for (paramInt = i.a.a.b.b.a.h(1, this.aadf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mdE != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.mdE);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.type) + i.a.a.b.b.a.cJ(4, this.ZUG) + i.a.a.b.b.a.cJ(5, this.aadg);
      paramInt = i;
      if (this.wul != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.wul);
      }
      i = paramInt + i.a.a.b.b.a.q(7, this.aadh) + i.a.a.b.b.a.q(8, this.aadi);
      paramInt = i;
      if (this.ZbX != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZbX);
      }
      i = paramInt;
      if (this.aadj != null) {
        i = paramInt + i.a.a.a.qC(10, this.aadj.computeSize());
      }
      i = i + i.a.a.b.b.a.q(11, this.aadk) + i.a.a.b.b.a.cJ(12, this.aadl) + i.a.a.b.b.a.cJ(13, this.aadm);
      paramInt = i;
      if (this.aadn != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.aadn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(15, this.aado);
      paramInt = i;
      if (this.aadp != null) {
        paramInt = i + i.a.a.a.qC(16, this.aadp.computeSize());
      }
      i = paramInt;
      if (this.aadq != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.aadq);
      }
      AppMethodBeat.o(258863);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258863);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bvo localbvo = (bvo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(258863);
          return -1;
        case 1: 
          localbvo.aadf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258863);
          return 0;
        case 2: 
          localbvo.mdE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258863);
          return 0;
        case 3: 
          localbvo.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258863);
          return 0;
        case 4: 
          localbvo.ZUG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258863);
          return 0;
        case 5: 
          localbvo.aadg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258863);
          return 0;
        case 6: 
          localbvo.wul = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258863);
          return 0;
        case 7: 
          localbvo.aadh = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258863);
          return 0;
        case 8: 
          localbvo.aadi = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258863);
          return 0;
        case 9: 
          localbvo.ZbX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258863);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzc)localObject2).parseFrom((byte[])localObject1);
            }
            localbvo.aadj = ((bzc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258863);
          return 0;
        case 11: 
          localbvo.aadk = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258863);
          return 0;
        case 12: 
          localbvo.aadl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258863);
          return 0;
        case 13: 
          localbvo.aadm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258863);
          return 0;
        case 14: 
          localbvo.aadn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258863);
          return 0;
        case 15: 
          localbvo.aado = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258863);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aff();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aff)localObject2).parseFrom((byte[])localObject1);
            }
            localbvo.aadp = ((aff)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258863);
          return 0;
        }
        localbvo.aadq = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258863);
        return 0;
      }
      AppMethodBeat.o(258863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvo
 * JD-Core Version:    0.7.0.1
 */