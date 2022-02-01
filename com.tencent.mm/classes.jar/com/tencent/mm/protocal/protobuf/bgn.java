package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgn
  extends dyl
{
  public String RLN;
  public int SRk;
  public int SRl;
  public long klE;
  public long object_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231431);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RLN != null) {
        paramVarArgs.f(2, this.RLN);
      }
      paramVarArgs.bm(3, this.object_id);
      paramVarArgs.bm(4, this.klE);
      paramVarArgs.aY(5, this.SRk);
      paramVarArgs.aY(6, this.SRl);
      paramVarArgs.aY(7, this.scene);
      AppMethodBeat.o(231431);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label580;
      }
    }
    label580:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RLN != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RLN);
      }
      paramInt = g.a.a.b.b.a.p(3, this.object_id);
      int j = g.a.a.b.b.a.p(4, this.klE);
      int k = g.a.a.b.b.a.bM(5, this.SRk);
      int m = g.a.a.b.b.a.bM(6, this.SRl);
      int n = g.a.a.b.b.a.bM(7, this.scene);
      AppMethodBeat.o(231431);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231431);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bgn localbgn = (bgn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231431);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localbgn.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(231431);
          return 0;
        case 2: 
          localbgn.RLN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231431);
          return 0;
        case 3: 
          localbgn.object_id = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(231431);
          return 0;
        case 4: 
          localbgn.klE = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(231431);
          return 0;
        case 5: 
          localbgn.SRk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(231431);
          return 0;
        case 6: 
          localbgn.SRl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(231431);
          return 0;
        }
        localbgn.scene = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(231431);
        return 0;
      }
      AppMethodBeat.o(231431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgn
 * JD-Core Version:    0.7.0.1
 */