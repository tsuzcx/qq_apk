package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends dyl
{
  public String RDj;
  public LinkedList<m> RDn;
  public bd RDo;
  public long RDp;
  public String RDq;
  public String RDr;
  public String RDs;
  public String RDt;
  public long RDw;
  public int scene;
  public String title;
  
  public k()
  {
    AppMethodBeat.i(91318);
    this.RDn = new LinkedList();
    AppMethodBeat.o(91318);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91319);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      paramVarArgs.bm(3, this.RDw);
      paramVarArgs.e(5, 8, this.RDn);
      paramVarArgs.aY(7, this.scene);
      if (this.RDj != null) {
        paramVarArgs.f(8, this.RDj);
      }
      if (this.RDo != null)
      {
        paramVarArgs.oE(9, this.RDo.computeSize());
        this.RDo.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(10, this.RDp);
      if (this.RDq != null) {
        paramVarArgs.f(11, this.RDq);
      }
      if (this.RDr != null) {
        paramVarArgs.f(12, this.RDr);
      }
      if (this.RDs != null) {
        paramVarArgs.f(13, this.RDs);
      }
      if (this.RDt != null) {
        paramVarArgs.f(14, this.RDt);
      }
      AppMethodBeat.o(91319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1052;
      }
    }
    label1052:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.title);
      }
      i = i + g.a.a.b.b.a.p(3, this.RDw) + g.a.a.a.c(5, 8, this.RDn) + g.a.a.b.b.a.bM(7, this.scene);
      paramInt = i;
      if (this.RDj != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RDj);
      }
      i = paramInt;
      if (this.RDo != null) {
        i = paramInt + g.a.a.a.oD(9, this.RDo.computeSize());
      }
      i += g.a.a.b.b.a.p(10, this.RDp);
      paramInt = i;
      if (this.RDq != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.RDq);
      }
      i = paramInt;
      if (this.RDr != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.RDr);
      }
      paramInt = i;
      if (this.RDs != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.RDs);
      }
      i = paramInt;
      if (this.RDt != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.RDt);
      }
      AppMethodBeat.o(91319);
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
        AppMethodBeat.o(91319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        case 6: 
        default: 
          AppMethodBeat.o(91319);
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
            localk.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 2: 
          localk.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 3: 
          localk.RDw = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91319);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new m();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((m)localObject2).parseFrom((byte[])localObject1);
            }
            localk.RDn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 7: 
          localk.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91319);
          return 0;
        case 8: 
          localk.RDj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 9: 
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
            localk.RDo = ((bd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 10: 
          localk.RDp = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91319);
          return 0;
        case 11: 
          localk.RDq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 12: 
          localk.RDr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 13: 
          localk.RDs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91319);
          return 0;
        }
        localk.RDt = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91319);
        return 0;
      }
      AppMethodBeat.o(91319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.k
 * JD-Core Version:    0.7.0.1
 */