package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class e
  extends dyl
{
  public LinkedList<a> Fmf;
  public long Fmg;
  public d Fmh;
  public int scene;
  public long timestamp;
  
  public e()
  {
    AppMethodBeat.i(187543);
    this.Fmf = new LinkedList();
    AppMethodBeat.o(187543);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187545);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.Fmg);
      paramVarArgs.bm(3, this.timestamp);
      paramVarArgs.aY(4, this.scene);
      if (this.Fmh != null)
      {
        paramVarArgs.oE(5, this.Fmh.computeSize());
        this.Fmh.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.Fmf);
      AppMethodBeat.o(187545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.Fmg) + g.a.a.b.b.a.p(3, this.timestamp) + g.a.a.b.b.a.bM(4, this.scene);
      paramInt = i;
      if (this.Fmh != null) {
        paramInt = i + g.a.a.a.oD(5, this.Fmh.computeSize());
      }
      i = g.a.a.a.c(6, 8, this.Fmf);
      AppMethodBeat.o(187545);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fmf.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(187545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(187545);
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
            locale.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(187545);
          return 0;
        case 2: 
          locale.Fmg = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(187545);
          return 0;
        case 3: 
          locale.timestamp = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(187545);
          return 0;
        case 4: 
          locale.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(187545);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            locale.Fmh = ((d)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(187545);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new a();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((a)localObject2).parseFrom((byte[])localObject1);
          }
          locale.Fmf.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(187545);
        return 0;
      }
      AppMethodBeat.o(187545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.e
 * JD-Core Version:    0.7.0.1
 */