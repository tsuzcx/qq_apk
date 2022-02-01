package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvt
  extends cpx
{
  public int BYF;
  public double Gdg;
  public double Gdh;
  public String Gdi;
  public LinkedList<dom> Gdj;
  public int scene;
  public String sessionId;
  
  public dvt()
  {
    AppMethodBeat.i(121112);
    this.Gdj = new LinkedList();
    AppMethodBeat.o(121112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121113);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.Gdg);
      paramVarArgs.e(3, this.Gdh);
      if (this.Gdi != null) {
        paramVarArgs.d(4, this.Gdi);
      }
      paramVarArgs.aR(5, this.BYF);
      if (this.sessionId != null) {
        paramVarArgs.d(6, this.sessionId);
      }
      paramVarArgs.aR(7, this.scene);
      paramVarArgs.e(8, 8, this.Gdj);
      AppMethodBeat.o(121113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label756;
      }
    }
    label756:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 8) + (f.a.a.b.b.a.fK(3) + 8);
      paramInt = i;
      if (this.Gdi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gdi);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.BYF);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sessionId);
      }
      i = f.a.a.b.b.a.bx(7, this.scene);
      int j = f.a.a.a.c(8, 8, this.Gdj);
      AppMethodBeat.o(121113);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gdj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvt localdvt = (dvt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121113);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvt.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(121113);
          return 0;
        case 2: 
          localdvt.Gdg = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(121113);
          return 0;
        case 3: 
          localdvt.Gdh = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(121113);
          return 0;
        case 4: 
          localdvt.Gdi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 5: 
          localdvt.BYF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(121113);
          return 0;
        case 6: 
          localdvt.sessionId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 7: 
          localdvt.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(121113);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dom();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dom)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdvt.Gdj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      AppMethodBeat.o(121113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvt
 * JD-Core Version:    0.7.0.1
 */