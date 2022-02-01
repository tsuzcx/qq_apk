package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdn
  extends dyl
{
  public int CNb;
  public LinkedList<eaf> CPO;
  public String CPt;
  public int CQe;
  public int CQf;
  public int Tlp;
  
  public cdn()
  {
    AppMethodBeat.i(152596);
    this.CPO = new LinkedList();
    AppMethodBeat.o(152596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152597);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.CNb);
      paramVarArgs.aY(3, this.CQe);
      paramVarArgs.aY(4, this.CQf);
      if (this.CPt != null) {
        paramVarArgs.f(5, this.CPt);
      }
      paramVarArgs.aY(6, this.Tlp);
      paramVarArgs.e(7, 8, this.CPO);
      AppMethodBeat.o(152597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CNb) + g.a.a.b.b.a.bM(3, this.CQe) + g.a.a.b.b.a.bM(4, this.CQf);
      paramInt = i;
      if (this.CPt != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.CPt);
      }
      i = g.a.a.b.b.a.bM(6, this.Tlp);
      int j = g.a.a.a.c(7, 8, this.CPO);
      AppMethodBeat.o(152597);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CPO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cdn localcdn = (cdn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152597);
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
            localcdn.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152597);
          return 0;
        case 2: 
          localcdn.CNb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152597);
          return 0;
        case 3: 
          localcdn.CQe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152597);
          return 0;
        case 4: 
          localcdn.CQf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152597);
          return 0;
        case 5: 
          localcdn.CPt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152597);
          return 0;
        case 6: 
          localcdn.Tlp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152597);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localcdn.CPO.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152597);
        return 0;
      }
      AppMethodBeat.o(152597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdn
 * JD-Core Version:    0.7.0.1
 */