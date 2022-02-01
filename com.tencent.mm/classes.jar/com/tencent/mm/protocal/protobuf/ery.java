package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ery
  extends com.tencent.mm.bx.a
{
  public String MD5;
  public int Nju;
  public String Url;
  public int abvO;
  public int abvP;
  public LinkedList<fcm> abvQ;
  public com.tencent.mm.bx.b abvR;
  public String abvS;
  
  public ery()
  {
    AppMethodBeat.i(152670);
    this.abvQ = new LinkedList();
    AppMethodBeat.o(152670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152671);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.MD5 == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: MD5");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Url");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.abvS == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: OriginalMD5");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.g(1, this.MD5);
      }
      paramVarArgs.bS(2, this.abvO);
      if (this.Url != null) {
        paramVarArgs.g(3, this.Url);
      }
      paramVarArgs.bS(4, this.abvP);
      paramVarArgs.e(5, 8, this.abvQ);
      if (this.abvR != null) {
        paramVarArgs.d(6, this.abvR);
      }
      if (this.abvS != null) {
        paramVarArgs.g(7, this.abvS);
      }
      paramVarArgs.bS(8, this.Nju);
      AppMethodBeat.o(152671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label792;
      }
    }
    label792:
    for (paramInt = i.a.a.b.b.a.h(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abvO);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.abvP) + i.a.a.a.c(5, 8, this.abvQ);
      paramInt = i;
      if (this.abvR != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.abvR);
      }
      i = paramInt;
      if (this.abvS != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abvS);
      }
      paramInt = i.a.a.b.b.a.cJ(8, this.Nju);
      AppMethodBeat.o(152671);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abvQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: MD5");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: Url");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        if (this.abvS == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: OriginalMD5");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ery localery = (ery)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152671);
          return -1;
        case 1: 
          localery.MD5 = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 2: 
          localery.abvO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152671);
          return 0;
        case 3: 
          localery.Url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 4: 
          localery.abvP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152671);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fcm localfcm = new fcm();
            if ((localObject != null) && (localObject.length > 0)) {
              localfcm.parseFrom((byte[])localObject);
            }
            localery.abvQ.add(localfcm);
            paramInt += 1;
          }
          AppMethodBeat.o(152671);
          return 0;
        case 6: 
          localery.abvR = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(152671);
          return 0;
        case 7: 
          localery.abvS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152671);
          return 0;
        }
        localery.Nju = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152671);
        return 0;
      }
      AppMethodBeat.o(152671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ery
 * JD-Core Version:    0.7.0.1
 */