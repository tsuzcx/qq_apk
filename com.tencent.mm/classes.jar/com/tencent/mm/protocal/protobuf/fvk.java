package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fvk
  extends com.tencent.mm.bx.a
{
  public LinkedList<FinderObject> ZIQ;
  public int aahh;
  public int aahj;
  public azh aahk;
  public FinderContact contact;
  
  public fvk()
  {
    AppMethodBeat.i(258749);
    this.ZIQ = new LinkedList();
    AppMethodBeat.o(258749);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258754);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.qD(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aahh);
      paramVarArgs.e(3, 8, this.ZIQ);
      paramVarArgs.bS(6, this.aahj);
      if (this.aahk != null)
      {
        paramVarArgs.qD(7, this.aahk.computeSize());
        this.aahk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258754);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label632;
      }
    }
    label632:
    for (paramInt = i.a.a.a.qC(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aahh) + i.a.a.a.c(3, 8, this.ZIQ) + i.a.a.b.b.a.cJ(6, this.aahj);
      paramInt = i;
      if (this.aahk != null) {
        paramInt = i + i.a.a.a.qC(7, this.aahk.computeSize());
      }
      AppMethodBeat.o(258754);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZIQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258754);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fvk localfvk = (fvk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        case 5: 
        default: 
          AppMethodBeat.o(258754);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localfvk.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258754);
          return 0;
        case 2: 
          localfvk.aahh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258754);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localfvk.ZIQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258754);
          return 0;
        case 6: 
          localfvk.aahj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258754);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new azh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((azh)localObject2).parseFrom((byte[])localObject1);
          }
          localfvk.aahk = ((azh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258754);
        return 0;
      }
      AppMethodBeat.o(258754);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvk
 * JD-Core Version:    0.7.0.1
 */