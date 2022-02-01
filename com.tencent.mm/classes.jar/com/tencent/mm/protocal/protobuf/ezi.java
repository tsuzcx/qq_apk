package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ezi
  extends com.tencent.mm.cd.a
{
  public LinkedList<FinderObject> SGi;
  public int SVR;
  public int SVT;
  public aup SVU;
  public FinderContact contact;
  
  public ezi()
  {
    AppMethodBeat.i(197468);
    this.SGi = new LinkedList();
    AppMethodBeat.o(197468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197478);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.oE(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.SVR);
      paramVarArgs.e(3, 8, this.SGi);
      paramVarArgs.aY(6, this.SVT);
      if (this.SVU != null)
      {
        paramVarArgs.oE(7, this.SVU.computeSize());
        this.SVU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(197478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label636;
      }
    }
    label636:
    for (paramInt = g.a.a.a.oD(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SVR) + g.a.a.a.c(3, 8, this.SGi) + g.a.a.b.b.a.bM(6, this.SVT);
      paramInt = i;
      if (this.SVU != null) {
        paramInt = i + g.a.a.a.oD(7, this.SVU.computeSize());
      }
      AppMethodBeat.o(197478);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SGi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(197478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ezi localezi = (ezi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        case 5: 
        default: 
          AppMethodBeat.o(197478);
          return -1;
        case 1: 
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
            localezi.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(197478);
          return 0;
        case 2: 
          localezi.SVR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(197478);
          return 0;
        case 3: 
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
            localezi.SGi.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(197478);
          return 0;
        case 6: 
          localezi.SVT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(197478);
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
          localezi.SVU = ((aup)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(197478);
        return 0;
      }
      AppMethodBeat.o(197478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezi
 * JD-Core Version:    0.7.0.1
 */