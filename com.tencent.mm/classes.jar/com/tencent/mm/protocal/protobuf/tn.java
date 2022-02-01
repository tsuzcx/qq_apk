package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tn
  extends dyl
{
  public int GIu;
  public LinkedList<eak> Sdm;
  public String Sdn;
  
  public tn()
  {
    AppMethodBeat.i(91389);
    this.Sdm = new LinkedList();
    AppMethodBeat.o(91389);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91390);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.GIu);
      paramVarArgs.e(3, 8, this.Sdm);
      if (this.Sdn != null) {
        paramVarArgs.f(4, this.Sdn);
      }
      AppMethodBeat.o(91390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.GIu) + g.a.a.a.c(3, 8, this.Sdm);
      paramInt = i;
      if (this.Sdn != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sdn);
      }
      AppMethodBeat.o(91390);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sdm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91390);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        tn localtn = (tn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91390);
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
            localtn.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91390);
          return 0;
        case 2: 
          localtn.GIu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91390);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eak();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eak)localObject2).parseFrom((byte[])localObject1);
            }
            localtn.Sdm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91390);
          return 0;
        }
        localtn.Sdn = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91390);
        return 0;
      }
      AppMethodBeat.o(91390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tn
 * JD-Core Version:    0.7.0.1
 */