package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends dyl
{
  public String RDj;
  public bd RDo;
  public long RDp;
  public String RDq;
  public String RDr;
  public String RDs;
  public String RDt;
  public int scene;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250228);
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
      paramVarArgs.aY(3, this.scene);
      if (this.RDj != null) {
        paramVarArgs.f(4, this.RDj);
      }
      if (this.RDo != null)
      {
        paramVarArgs.oE(5, this.RDo.computeSize());
        this.RDo.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.RDp);
      if (this.RDq != null) {
        paramVarArgs.f(7, this.RDq);
      }
      if (this.RDr != null) {
        paramVarArgs.f(8, this.RDr);
      }
      if (this.RDs != null) {
        paramVarArgs.f(9, this.RDs);
      }
      if (this.RDt != null) {
        paramVarArgs.f(10, this.RDt);
      }
      AppMethodBeat.o(250228);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.title);
      }
      i += g.a.a.b.b.a.bM(3, this.scene);
      paramInt = i;
      if (this.RDj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RDj);
      }
      i = paramInt;
      if (this.RDo != null) {
        i = paramInt + g.a.a.a.oD(5, this.RDo.computeSize());
      }
      i += g.a.a.b.b.a.p(6, this.RDp);
      paramInt = i;
      if (this.RDq != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RDq);
      }
      i = paramInt;
      if (this.RDr != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.RDr);
      }
      paramInt = i;
      if (this.RDs != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.RDs);
      }
      i = paramInt;
      if (this.RDt != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.RDt);
      }
      AppMethodBeat.o(250228);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250228);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(250228);
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
            locali.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250228);
          return 0;
        case 2: 
          locali.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(250228);
          return 0;
        case 3: 
          locali.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(250228);
          return 0;
        case 4: 
          locali.RDj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(250228);
          return 0;
        case 5: 
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
            locali.RDo = ((bd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250228);
          return 0;
        case 6: 
          locali.RDp = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(250228);
          return 0;
        case 7: 
          locali.RDq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(250228);
          return 0;
        case 8: 
          locali.RDr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(250228);
          return 0;
        case 9: 
          locali.RDs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(250228);
          return 0;
        }
        locali.RDt = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(250228);
        return 0;
      }
      AppMethodBeat.o(250228);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.i
 * JD-Core Version:    0.7.0.1
 */