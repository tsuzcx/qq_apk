package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnm
  extends dyl
{
  public LinkedList<String> TuN;
  public int TuP;
  public foh TuQ;
  public int Tva;
  public String Tvb;
  public String Url;
  public String lVG;
  
  public cnm()
  {
    AppMethodBeat.i(123614);
    this.TuN = new LinkedList();
    AppMethodBeat.o(123614);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123615);
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
      paramVarArgs.e(3, 1, this.TuN);
      paramVarArgs.aY(4, this.Tva);
      if (this.Url != null) {
        paramVarArgs.f(5, this.Url);
      }
      if (this.Tvb != null) {
        paramVarArgs.f(6, this.Tvb);
      }
      paramVarArgs.aY(7, this.TuP);
      if (this.TuQ != null)
      {
        paramVarArgs.oE(8, this.TuQ.computeSize());
        this.TuQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = i + g.a.a.a.c(3, 1, this.TuN) + g.a.a.b.b.a.bM(4, this.Tva);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Url);
      }
      i = paramInt;
      if (this.Tvb != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Tvb);
      }
      i += g.a.a.b.b.a.bM(7, this.TuP);
      paramInt = i;
      if (this.TuQ != null) {
        paramInt = i + g.a.a.a.oD(8, this.TuQ.computeSize());
      }
      AppMethodBeat.o(123615);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TuN.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123615);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cnm localcnm = (cnm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123615);
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
            localcnm.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123615);
          return 0;
        case 2: 
          localcnm.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123615);
          return 0;
        case 3: 
          localcnm.TuN.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(123615);
          return 0;
        case 4: 
          localcnm.Tva = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123615);
          return 0;
        case 5: 
          localcnm.Url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123615);
          return 0;
        case 6: 
          localcnm.Tvb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123615);
          return 0;
        case 7: 
          localcnm.TuP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123615);
          return 0;
        }
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
          localcnm.TuQ = ((foh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123615);
        return 0;
      }
      AppMethodBeat.o(123615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnm
 * JD-Core Version:    0.7.0.1
 */