package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bla
  extends dyy
{
  public LinkedList<FinderObject> SGi;
  public int SVR;
  public int SVS;
  public int SVT;
  public aup SVU;
  public FinderContact contact;
  
  public bla()
  {
    AppMethodBeat.i(204432);
    this.SGi = new LinkedList();
    AppMethodBeat.o(204432);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204443);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.oE(2, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.SVR);
      paramVarArgs.e(4, 8, this.SGi);
      paramVarArgs.aY(5, this.SVS);
      paramVarArgs.aY(6, this.SVT);
      if (this.SVU != null)
      {
        paramVarArgs.oE(7, this.SVU.computeSize());
        this.SVU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(204443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.contact != null) {
        i = paramInt + g.a.a.a.oD(2, this.contact.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(3, this.SVR) + g.a.a.a.c(4, 8, this.SGi) + g.a.a.b.b.a.bM(5, this.SVS) + g.a.a.b.b.a.bM(6, this.SVT);
      paramInt = i;
      if (this.SVU != null) {
        paramInt = i + g.a.a.a.oD(7, this.SVU.computeSize());
      }
      AppMethodBeat.o(204443);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SGi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bla localbla = (bla)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204443);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbla.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204443);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbla.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204443);
          return 0;
        case 3: 
          localbla.SVR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204443);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbla.SGi.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204443);
          return 0;
        case 5: 
          localbla.SVS = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204443);
          return 0;
        case 6: 
          localbla.SVT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204443);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aup();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aup)localObject2).parseFrom((byte[])localObject1);
          }
          localbla.SVU = ((aup)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(204443);
        return 0;
      }
      AppMethodBeat.o(204443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bla
 * JD-Core Version:    0.7.0.1
 */