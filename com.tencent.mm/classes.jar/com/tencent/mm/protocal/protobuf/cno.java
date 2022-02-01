package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class cno
  extends dyl
{
  public int SrG;
  public int TuO;
  public int TuP;
  public foh TuQ;
  public String Tvg;
  public int Tvh;
  public String lVG;
  public b rVk;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123618);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      if (this.rVk != null) {
        paramVarArgs.c(3, this.rVk);
      }
      if (this.Tvg != null) {
        paramVarArgs.f(4, this.Tvg);
      }
      paramVarArgs.aY(5, this.TuO);
      paramVarArgs.aY(6, this.TuP);
      if (this.TuQ != null)
      {
        paramVarArgs.oE(7, this.TuQ.computeSize());
        this.TuQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.SrG);
      if (this.session_id != null) {
        paramVarArgs.f(9, this.session_id);
      }
      paramVarArgs.aY(10, this.Tvh);
      AppMethodBeat.o(123618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt;
      if (this.rVk != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.rVk);
      }
      paramInt = i;
      if (this.Tvg != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tvg);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TuO) + g.a.a.b.b.a.bM(6, this.TuP);
      paramInt = i;
      if (this.TuQ != null) {
        paramInt = i + g.a.a.a.oD(7, this.TuQ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.SrG);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.session_id);
      }
      i = g.a.a.b.b.a.bM(10, this.Tvh);
      AppMethodBeat.o(123618);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cno localcno = (cno)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123618);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localcno.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        case 2: 
          localcno.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 3: 
          localcno.rVk = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(123618);
          return 0;
        case 4: 
          localcno.Tvg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 5: 
          localcno.TuO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123618);
          return 0;
        case 6: 
          localcno.TuP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123618);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new foh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((foh)localObject2).parseFrom((byte[])localObject1);
            }
            localcno.TuQ = ((foh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        case 8: 
          localcno.SrG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123618);
          return 0;
        case 9: 
          localcno.session_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123618);
          return 0;
        }
        localcno.Tvh = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(123618);
        return 0;
      }
      AppMethodBeat.o(123618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cno
 * JD-Core Version:    0.7.0.1
 */