package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dc
  extends com.tencent.mm.cd.a
{
  public int COi;
  public int CreateTime;
  public long HlH;
  public int RIK;
  public eaf RIL;
  public int RIM;
  public eaf RIN;
  public int RIO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133144);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RIL == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomId");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.RIN == null)
      {
        paramVarArgs = new b("Not all required fields were included: DigestContent");
        AppMethodBeat.o(133144);
        throw paramVarArgs;
      }
      if (this.RIL != null)
      {
        paramVarArgs.oE(1, this.RIL.computeSize());
        this.RIL.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.HlH);
      paramVarArgs.aY(3, this.RIK);
      paramVarArgs.aY(4, this.CreateTime);
      paramVarArgs.aY(5, this.RIM);
      if (this.RIN != null)
      {
        paramVarArgs.oE(6, this.RIN.computeSize());
        this.RIN.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.RIO);
      paramVarArgs.aY(8, this.COi);
      AppMethodBeat.o(133144);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RIL == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = g.a.a.a.oD(1, this.RIL.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.HlH) + g.a.a.b.b.a.bM(3, this.RIK) + g.a.a.b.b.a.bM(4, this.CreateTime) + g.a.a.b.b.a.bM(5, this.RIM);
      paramInt = i;
      if (this.RIN != null) {
        paramInt = i + g.a.a.a.oD(6, this.RIN.computeSize());
      }
      i = g.a.a.b.b.a.bM(7, this.RIO);
      int j = g.a.a.b.b.a.bM(8, this.COi);
      AppMethodBeat.o(133144);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RIL == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomId");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        if (this.RIN == null)
        {
          paramVarArgs = new b("Not all required fields were included: DigestContent");
          AppMethodBeat.o(133144);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133144);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dc localdc = (dc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        eaf localeaf;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133144);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localdc.RIL = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 2: 
          localdc.HlH = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(133144);
          return 0;
        case 3: 
          localdc.RIK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(133144);
          return 0;
        case 4: 
          localdc.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(133144);
          return 0;
        case 5: 
          localdc.RIM = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(133144);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localdc.RIN = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(133144);
          return 0;
        case 7: 
          localdc.RIO = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(133144);
          return 0;
        }
        localdc.COi = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(133144);
        return 0;
      }
      AppMethodBeat.o(133144);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dc
 * JD-Core Version:    0.7.0.1
 */