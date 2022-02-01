package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ur
  extends erp
{
  public b Zaa;
  public b Zab;
  public int Zac;
  public int Zad;
  public int Zae;
  public int oUj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259382);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Zaa != null) {
        paramVarArgs.d(2, this.Zaa);
      }
      paramVarArgs.bS(3, this.oUj);
      if (this.Zab != null) {
        paramVarArgs.d(4, this.Zab);
      }
      paramVarArgs.bS(5, this.Zac);
      paramVarArgs.bS(6, this.Zad);
      paramVarArgs.bS(7, this.Zae);
      AppMethodBeat.o(259382);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zaa != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.Zaa);
      }
      i += i.a.a.b.b.a.cJ(3, this.oUj);
      paramInt = i;
      if (this.Zab != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.Zab);
      }
      i = i.a.a.b.b.a.cJ(5, this.Zac);
      int j = i.a.a.b.b.a.cJ(6, this.Zad);
      int k = i.a.a.b.b.a.cJ(7, this.Zae);
      AppMethodBeat.o(259382);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259382);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ur localur = (ur)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259382);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localur.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259382);
          return 0;
        case 2: 
          localur.Zaa = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(259382);
          return 0;
        case 3: 
          localur.oUj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259382);
          return 0;
        case 4: 
          localur.Zab = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(259382);
          return 0;
        case 5: 
          localur.Zac = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259382);
          return 0;
        case 6: 
          localur.Zad = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259382);
          return 0;
        }
        localur.Zae = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259382);
        return 0;
      }
      AppMethodBeat.o(259382);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ur
 * JD-Core Version:    0.7.0.1
 */