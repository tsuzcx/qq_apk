package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends dyl
{
  public String RDj;
  public int RDl;
  public long RDm;
  public LinkedList<String> RDn;
  public bd RDo;
  public long RDp;
  public String RDq;
  public String RDr;
  public String RDs;
  public String RDt;
  public int scene;
  public String title;
  
  public g()
  {
    AppMethodBeat.i(91315);
    this.RDn = new LinkedList();
    AppMethodBeat.o(91315);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91316);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RDl);
      paramVarArgs.bm(3, this.RDm);
      if (this.title != null) {
        paramVarArgs.f(4, this.title);
      }
      paramVarArgs.e(5, 1, this.RDn);
      paramVarArgs.aY(6, this.scene);
      if (this.RDj != null) {
        paramVarArgs.f(7, this.RDj);
      }
      if (this.RDo != null)
      {
        paramVarArgs.oE(8, this.RDo.computeSize());
        this.RDo.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(9, this.RDp);
      if (this.RDq != null) {
        paramVarArgs.f(10, this.RDq);
      }
      if (this.RDr != null) {
        paramVarArgs.f(11, this.RDr);
      }
      if (this.RDs != null) {
        paramVarArgs.f(12, this.RDs);
      }
      if (this.RDt != null) {
        paramVarArgs.f(13, this.RDt);
      }
      AppMethodBeat.o(91316);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RDl) + g.a.a.b.b.a.p(3, this.RDm);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.title);
      }
      i = paramInt + g.a.a.a.c(5, 1, this.RDn) + g.a.a.b.b.a.bM(6, this.scene);
      paramInt = i;
      if (this.RDj != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RDj);
      }
      i = paramInt;
      if (this.RDo != null) {
        i = paramInt + g.a.a.a.oD(8, this.RDo.computeSize());
      }
      i += g.a.a.b.b.a.p(9, this.RDp);
      paramInt = i;
      if (this.RDq != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RDq);
      }
      i = paramInt;
      if (this.RDr != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.RDr);
      }
      paramInt = i;
      if (this.RDs != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.RDs);
      }
      i = paramInt;
      if (this.RDt != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.RDt);
      }
      AppMethodBeat.o(91316);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RDn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91316);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91316);
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
            localg.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 2: 
          localg.RDl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91316);
          return 0;
        case 3: 
          localg.RDm = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91316);
          return 0;
        case 4: 
          localg.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 5: 
          localg.RDn.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(91316);
          return 0;
        case 6: 
          localg.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91316);
          return 0;
        case 7: 
          localg.RDj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bd)localObject2).parseFrom((byte[])localObject1);
            }
            localg.RDo = ((bd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 9: 
          localg.RDp = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91316);
          return 0;
        case 10: 
          localg.RDq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 11: 
          localg.RDr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 12: 
          localg.RDs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91316);
          return 0;
        }
        localg.RDt = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91316);
        return 0;
      }
      AppMethodBeat.o(91316);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.g
 * JD-Core Version:    0.7.0.1
 */