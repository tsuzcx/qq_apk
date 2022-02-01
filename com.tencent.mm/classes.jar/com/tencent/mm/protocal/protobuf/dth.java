package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dth
  extends com.tencent.mm.bx.a
{
  public String Dke;
  public String Dkg;
  public dtg EHS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110858);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dke == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.Dkg == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.EHS == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(110858);
        throw paramVarArgs;
      }
      if (this.Dke != null) {
        paramVarArgs.d(1, this.Dke);
      }
      if (this.Dkg != null) {
        paramVarArgs.d(2, this.Dkg);
      }
      if (this.EHS != null)
      {
        paramVarArgs.kX(3, this.EHS.computeSize());
        this.EHS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dke == null) {
        break label574;
      }
    }
    label574:
    for (int i = f.a.a.b.b.a.e(1, this.Dke) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dkg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dkg);
      }
      i = paramInt;
      if (this.EHS != null) {
        i = paramInt + f.a.a.a.kW(3, this.EHS.computeSize());
      }
      AppMethodBeat.o(110858);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dke == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        if (this.Dkg == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        if (this.EHS == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadInfo");
          AppMethodBeat.o(110858);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dth localdth = (dth)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110858);
          return -1;
        case 1: 
          localdth.Dke = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110858);
          return 0;
        case 2: 
          localdth.Dkg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110858);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dtg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdth.EHS = ((dtg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110858);
        return 0;
      }
      AppMethodBeat.o(110858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dth
 * JD-Core Version:    0.7.0.1
 */