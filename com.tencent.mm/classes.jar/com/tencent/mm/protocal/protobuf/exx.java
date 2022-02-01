package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class exx
  extends com.tencent.mm.bx.a
{
  public String QCC;
  public LinkedList<fnq> abzx;
  public String aesKey;
  public String md5;
  public int oZp;
  public int omT;
  public int playtime;
  public int thumbHeight;
  public int thumbWidth;
  public String url;
  
  public exx()
  {
    AppMethodBeat.i(127174);
    this.abzx = new LinkedList();
    AppMethodBeat.o(127174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127175);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.QCC == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(127175);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.abzx);
      if (this.QCC != null) {
        paramVarArgs.g(2, this.QCC);
      }
      if (this.md5 != null) {
        paramVarArgs.g(3, this.md5);
      }
      if (this.aesKey != null) {
        paramVarArgs.g(4, this.aesKey);
      }
      if (this.url != null) {
        paramVarArgs.g(5, this.url);
      }
      paramVarArgs.bS(6, this.omT);
      paramVarArgs.bS(7, this.oZp);
      paramVarArgs.bS(8, this.playtime);
      paramVarArgs.bS(9, this.thumbHeight);
      paramVarArgs.bS(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.abzx) + 0;
      paramInt = i;
      if (this.QCC != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.QCC);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.md5);
      }
      paramInt = i;
      if (this.aesKey != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aesKey);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.url);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.omT);
      int j = i.a.a.b.b.a.cJ(7, this.oZp);
      int k = i.a.a.b.b.a.cJ(8, this.playtime);
      int m = i.a.a.b.b.a.cJ(9, this.thumbHeight);
      int n = i.a.a.b.b.a.cJ(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return i + paramInt + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abzx.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.QCC == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(127175);
        throw paramVarArgs;
      }
      AppMethodBeat.o(127175);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      exx localexx = (exx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127175);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fnq localfnq = new fnq();
          if ((localObject != null) && (localObject.length > 0)) {
            localfnq.parseFrom((byte[])localObject);
          }
          localexx.abzx.add(localfnq);
          paramInt += 1;
        }
        AppMethodBeat.o(127175);
        return 0;
      case 2: 
        localexx.QCC = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 3: 
        localexx.md5 = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 4: 
        localexx.aesKey = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 5: 
        localexx.url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 6: 
        localexx.omT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127175);
        return 0;
      case 7: 
        localexx.oZp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127175);
        return 0;
      case 8: 
        localexx.playtime = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127175);
        return 0;
      case 9: 
        localexx.thumbHeight = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127175);
        return 0;
      }
      localexx.thumbWidth = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(127175);
      return 0;
    }
    AppMethodBeat.o(127175);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exx
 * JD-Core Version:    0.7.0.1
 */