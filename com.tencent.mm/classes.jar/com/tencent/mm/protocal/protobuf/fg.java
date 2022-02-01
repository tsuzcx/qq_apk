package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fg
  extends cpx
{
  public int DRl;
  public int DRm;
  public int DRn;
  public long DRo;
  public int DSk;
  public int DSn;
  public long DSq;
  public String content;
  public int nWg;
  public int scene;
  public String session_id;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103199);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aO(5, this.DSq);
      paramVarArgs.aR(6, this.nWg);
      paramVarArgs.aR(7, this.DSk);
      if (this.title != null) {
        paramVarArgs.d(8, this.title);
      }
      paramVarArgs.aR(9, this.scene);
      paramVarArgs.aR(10, this.DRn);
      paramVarArgs.aR(11, this.DRm);
      paramVarArgs.aR(12, this.DRl);
      if (this.session_id != null) {
        paramVarArgs.d(13, this.session_id);
      }
      paramVarArgs.aO(14, this.DRo);
      paramVarArgs.aR(15, this.DSn);
      AppMethodBeat.o(103199);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.content);
      }
      i = i + f.a.a.b.b.a.p(5, this.DSq) + f.a.a.b.b.a.bx(6, this.nWg) + f.a.a.b.b.a.bx(7, this.DSk);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.title);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.scene) + f.a.a.b.b.a.bx(10, this.DRn) + f.a.a.b.b.a.bx(11, this.DRm) + f.a.a.b.b.a.bx(12, this.DRl);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.session_id);
      }
      i = f.a.a.b.b.a.p(14, this.DRo);
      int j = f.a.a.b.b.a.bx(15, this.DSn);
      AppMethodBeat.o(103199);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(103199);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fg localfg = (fg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(103199);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103199);
          return 0;
        case 2: 
          localfg.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 4: 
          localfg.content = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 5: 
          localfg.DSq = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(103199);
          return 0;
        case 6: 
          localfg.nWg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103199);
          return 0;
        case 7: 
          localfg.DSk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103199);
          return 0;
        case 8: 
          localfg.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 9: 
          localfg.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103199);
          return 0;
        case 10: 
          localfg.DRn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103199);
          return 0;
        case 11: 
          localfg.DRm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103199);
          return 0;
        case 12: 
          localfg.DRl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103199);
          return 0;
        case 13: 
          localfg.session_id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 14: 
          localfg.DRo = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(103199);
          return 0;
        }
        localfg.DSn = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(103199);
        return 0;
      }
      AppMethodBeat.o(103199);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fg
 * JD-Core Version:    0.7.0.1
 */