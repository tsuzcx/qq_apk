package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cae
  extends com.tencent.mm.bw.a
{
  public String DQi;
  public String FoU;
  public String FoV;
  public String Fpg;
  public String Fpi;
  public String Fpj;
  public String Fpk;
  public String Fpl;
  public caf Fpm;
  public String app_id;
  public int dbL;
  public int exL;
  public String iAC;
  public String iod;
  public String nickname;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152638);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iod != null) {
        paramVarArgs.d(1, this.iod);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      paramVarArgs.aR(3, this.type);
      if (this.iAC != null) {
        paramVarArgs.d(4, this.iAC);
      }
      if (this.FoU != null) {
        paramVarArgs.d(5, this.FoU);
      }
      if (this.FoV != null) {
        paramVarArgs.d(6, this.FoV);
      }
      paramVarArgs.aR(7, this.dbL);
      if (this.Fpi != null) {
        paramVarArgs.d(8, this.Fpi);
      }
      if (this.Fpj != null) {
        paramVarArgs.d(9, this.Fpj);
      }
      if (this.Fpk != null) {
        paramVarArgs.d(10, this.Fpk);
      }
      if (this.Fpl != null) {
        paramVarArgs.d(11, this.Fpl);
      }
      if (this.Fpm != null)
      {
        paramVarArgs.ln(12, this.Fpm.computeSize());
        this.Fpm.writeFields(paramVarArgs);
      }
      if (this.DQi != null) {
        paramVarArgs.d(13, this.DQi);
      }
      if (this.app_id != null) {
        paramVarArgs.d(14, this.app_id);
      }
      paramVarArgs.aR(15, this.exL);
      if (this.Fpg != null) {
        paramVarArgs.d(16, this.Fpg);
      }
      AppMethodBeat.o(152638);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iod == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.b.b.a.e(1, this.iod) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nickname);
      }
      i += f.a.a.b.b.a.bx(3, this.type);
      paramInt = i;
      if (this.iAC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iAC);
      }
      i = paramInt;
      if (this.FoU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FoU);
      }
      paramInt = i;
      if (this.FoV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FoV);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.dbL);
      paramInt = i;
      if (this.Fpi != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Fpi);
      }
      i = paramInt;
      if (this.Fpj != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Fpj);
      }
      paramInt = i;
      if (this.Fpk != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Fpk);
      }
      i = paramInt;
      if (this.Fpl != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Fpl);
      }
      paramInt = i;
      if (this.Fpm != null) {
        paramInt = i + f.a.a.a.lm(12, this.Fpm.computeSize());
      }
      i = paramInt;
      if (this.DQi != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DQi);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.app_id);
      }
      i = paramInt + f.a.a.b.b.a.bx(15, this.exL);
      paramInt = i;
      if (this.Fpg != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Fpg);
      }
      AppMethodBeat.o(152638);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152638);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cae localcae = (cae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152638);
          return -1;
        case 1: 
          localcae.iod = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 2: 
          localcae.nickname = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 3: 
          localcae.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152638);
          return 0;
        case 4: 
          localcae.iAC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 5: 
          localcae.FoU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 6: 
          localcae.FoV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 7: 
          localcae.dbL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152638);
          return 0;
        case 8: 
          localcae.Fpi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 9: 
          localcae.Fpj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 10: 
          localcae.Fpk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 11: 
          localcae.Fpl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((caf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcae.Fpm = ((caf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152638);
          return 0;
        case 13: 
          localcae.DQi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 14: 
          localcae.app_id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 15: 
          localcae.exL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152638);
          return 0;
        }
        localcae.Fpg = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152638);
        return 0;
      }
      AppMethodBeat.o(152638);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cae
 * JD-Core Version:    0.7.0.1
 */