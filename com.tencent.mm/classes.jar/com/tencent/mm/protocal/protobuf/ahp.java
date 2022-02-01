package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ahp
  extends com.tencent.mm.bx.a
{
  public String Dke;
  public long Dkf;
  public String Dkg;
  public LinkedList<ahn> Dkh;
  public int mBC;
  
  public ahp()
  {
    AppMethodBeat.i(110849);
    this.Dkh = new LinkedList();
    AppMethodBeat.o(110849);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110850);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dke == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.Dkg == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.Dke != null) {
        paramVarArgs.d(1, this.Dke);
      }
      paramVarArgs.aG(2, this.Dkf);
      paramVarArgs.aR(3, this.mBC);
      if (this.Dkg != null) {
        paramVarArgs.d(4, this.Dkg);
      }
      paramVarArgs.e(5, 8, this.Dkh);
      AppMethodBeat.o(110850);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dke == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.Dke) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.Dkf) + f.a.a.b.b.a.bA(3, this.mBC);
      paramInt = i;
      if (this.Dkg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dkg);
      }
      i = f.a.a.a.c(5, 8, this.Dkh);
      AppMethodBeat.o(110850);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dkh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dke == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110850);
          throw paramVarArgs;
        }
        if (this.Dkg == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(110850);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110850);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ahp localahp = (ahp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110850);
          return -1;
        case 1: 
          localahp.Dke = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110850);
          return 0;
        case 2: 
          localahp.Dkf = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(110850);
          return 0;
        case 3: 
          localahp.mBC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(110850);
          return 0;
        case 4: 
          localahp.Dkg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110850);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahp.Dkh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110850);
        return 0;
      }
      AppMethodBeat.o(110850);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahp
 * JD-Core Version:    0.7.0.1
 */