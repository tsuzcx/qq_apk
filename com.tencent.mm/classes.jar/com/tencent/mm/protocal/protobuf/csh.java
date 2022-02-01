package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class csh
  extends com.tencent.mm.cd.a
{
  public long FEO;
  public int TAg;
  public LinkedList<csg> TAh;
  public int TAi;
  public long TAj;
  public long TAk;
  public long TAl;
  public LinkedList<cse> TAm;
  public dwi TAn;
  public String clientId;
  public long jPg;
  public int kQn;
  public int postStage;
  
  public csh()
  {
    AppMethodBeat.i(169081);
    this.TAh = new LinkedList();
    this.TAm = new LinkedList();
    AppMethodBeat.o(169081);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169082);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.clientId != null) {
        paramVarArgs.f(1, this.clientId);
      }
      paramVarArgs.aY(2, this.kQn);
      paramVarArgs.aY(3, this.TAg);
      paramVarArgs.e(4, 8, this.TAh);
      paramVarArgs.aY(5, this.TAi);
      paramVarArgs.aY(6, this.postStage);
      paramVarArgs.bm(7, this.TAj);
      paramVarArgs.bm(8, this.FEO);
      paramVarArgs.bm(9, this.TAk);
      paramVarArgs.bm(10, this.jPg);
      paramVarArgs.bm(11, this.TAl);
      paramVarArgs.e(12, 8, this.TAm);
      if (this.TAn != null)
      {
        paramVarArgs.oE(13, this.TAn.computeSize());
        this.TAn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169082);
      return 0;
    }
    if (paramInt == 1) {
      if (this.clientId == null) {
        break label976;
      }
    }
    label976:
    for (paramInt = g.a.a.b.b.a.g(1, this.clientId) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.kQn) + g.a.a.b.b.a.bM(3, this.TAg) + g.a.a.a.c(4, 8, this.TAh) + g.a.a.b.b.a.bM(5, this.TAi) + g.a.a.b.b.a.bM(6, this.postStage) + g.a.a.b.b.a.p(7, this.TAj) + g.a.a.b.b.a.p(8, this.FEO) + g.a.a.b.b.a.p(9, this.TAk) + g.a.a.b.b.a.p(10, this.jPg) + g.a.a.b.b.a.p(11, this.TAl) + g.a.a.a.c(12, 8, this.TAm);
      paramInt = i;
      if (this.TAn != null) {
        paramInt = i + g.a.a.a.oD(13, this.TAn.computeSize());
      }
      AppMethodBeat.o(169082);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TAh.clear();
        this.TAm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169082);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        csh localcsh = (csh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169082);
          return -1;
        case 1: 
          localcsh.clientId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169082);
          return 0;
        case 2: 
          localcsh.kQn = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169082);
          return 0;
        case 3: 
          localcsh.TAg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169082);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new csg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((csg)localObject2).parseFrom((byte[])localObject1);
            }
            localcsh.TAh.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169082);
          return 0;
        case 5: 
          localcsh.TAi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169082);
          return 0;
        case 6: 
          localcsh.postStage = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169082);
          return 0;
        case 7: 
          localcsh.TAj = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169082);
          return 0;
        case 8: 
          localcsh.FEO = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169082);
          return 0;
        case 9: 
          localcsh.TAk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169082);
          return 0;
        case 10: 
          localcsh.jPg = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169082);
          return 0;
        case 11: 
          localcsh.TAl = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169082);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cse();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cse)localObject2).parseFrom((byte[])localObject1);
            }
            localcsh.TAm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169082);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dwi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dwi)localObject2).parseFrom((byte[])localObject1);
          }
          localcsh.TAn = ((dwi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169082);
        return 0;
      }
      AppMethodBeat.o(169082);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csh
 * JD-Core Version:    0.7.0.1
 */