package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvw
  extends com.tencent.mm.bw.a
{
  public String KHz;
  public String MBe;
  public String MBf;
  public String MBp;
  public String MBr;
  public String MBs;
  public String MBt;
  public String MBu;
  public cvx MBv;
  public String app_id;
  public int fuA;
  public String jGZ;
  public String nickname;
  public String remark;
  public int source;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152638);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jGZ != null) {
        paramVarArgs.e(1, this.jGZ);
      }
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      paramVarArgs.aM(3, this.type);
      if (this.remark != null) {
        paramVarArgs.e(4, this.remark);
      }
      if (this.MBe != null) {
        paramVarArgs.e(5, this.MBe);
      }
      if (this.MBf != null) {
        paramVarArgs.e(6, this.MBf);
      }
      paramVarArgs.aM(7, this.source);
      if (this.MBr != null) {
        paramVarArgs.e(8, this.MBr);
      }
      if (this.MBs != null) {
        paramVarArgs.e(9, this.MBs);
      }
      if (this.MBt != null) {
        paramVarArgs.e(10, this.MBt);
      }
      if (this.MBu != null) {
        paramVarArgs.e(11, this.MBu);
      }
      if (this.MBv != null)
      {
        paramVarArgs.ni(12, this.MBv.computeSize());
        this.MBv.writeFields(paramVarArgs);
      }
      if (this.KHz != null) {
        paramVarArgs.e(13, this.KHz);
      }
      if (this.app_id != null) {
        paramVarArgs.e(14, this.app_id);
      }
      paramVarArgs.aM(15, this.fuA);
      if (this.MBp != null) {
        paramVarArgs.e(16, this.MBp);
      }
      AppMethodBeat.o(152638);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jGZ == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = g.a.a.b.b.a.f(1, this.jGZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickname != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.nickname);
      }
      i += g.a.a.b.b.a.bu(3, this.type);
      paramInt = i;
      if (this.remark != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.remark);
      }
      i = paramInt;
      if (this.MBe != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MBe);
      }
      paramInt = i;
      if (this.MBf != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MBf);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.source);
      paramInt = i;
      if (this.MBr != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MBr);
      }
      i = paramInt;
      if (this.MBs != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.MBs);
      }
      paramInt = i;
      if (this.MBt != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MBt);
      }
      i = paramInt;
      if (this.MBu != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.MBu);
      }
      paramInt = i;
      if (this.MBv != null) {
        paramInt = i + g.a.a.a.nh(12, this.MBv.computeSize());
      }
      i = paramInt;
      if (this.KHz != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.KHz);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.app_id);
      }
      i = paramInt + g.a.a.b.b.a.bu(15, this.fuA);
      paramInt = i;
      if (this.MBp != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.MBp);
      }
      AppMethodBeat.o(152638);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152638);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cvw localcvw = (cvw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152638);
          return -1;
        case 1: 
          localcvw.jGZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 2: 
          localcvw.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 3: 
          localcvw.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152638);
          return 0;
        case 4: 
          localcvw.remark = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 5: 
          localcvw.MBe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 6: 
          localcvw.MBf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 7: 
          localcvw.source = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152638);
          return 0;
        case 8: 
          localcvw.MBr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 9: 
          localcvw.MBs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 10: 
          localcvw.MBt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 11: 
          localcvw.MBu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cvx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcvw.MBv = ((cvx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152638);
          return 0;
        case 13: 
          localcvw.KHz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 14: 
          localcvw.app_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 15: 
          localcvw.fuA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152638);
          return 0;
        }
        localcvw.MBp = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152638);
        return 0;
      }
      AppMethodBeat.o(152638);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvw
 * JD-Core Version:    0.7.0.1
 */