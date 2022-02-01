package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eeg
  extends com.tencent.mm.cd.a
{
  public String KeY;
  public int SbK;
  public LinkedList<esh> Uii;
  public String aesKey;
  public int lvw;
  public String md5;
  public int mgu;
  public int thumbHeight;
  public int thumbWidth;
  public String url;
  
  public eeg()
  {
    AppMethodBeat.i(127174);
    this.Uii = new LinkedList();
    AppMethodBeat.o(127174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127175);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KeY == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(127175);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.Uii);
      if (this.KeY != null) {
        paramVarArgs.f(2, this.KeY);
      }
      if (this.md5 != null) {
        paramVarArgs.f(3, this.md5);
      }
      if (this.aesKey != null) {
        paramVarArgs.f(4, this.aesKey);
      }
      if (this.url != null) {
        paramVarArgs.f(5, this.url);
      }
      paramVarArgs.aY(6, this.lvw);
      paramVarArgs.aY(7, this.mgu);
      paramVarArgs.aY(8, this.SbK);
      paramVarArgs.aY(9, this.thumbHeight);
      paramVarArgs.aY(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Uii) + 0;
      paramInt = i;
      if (this.KeY != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.KeY);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.md5);
      }
      paramInt = i;
      if (this.aesKey != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.aesKey);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.url);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.lvw);
      int j = g.a.a.b.b.a.bM(7, this.mgu);
      int k = g.a.a.b.b.a.bM(8, this.SbK);
      int m = g.a.a.b.b.a.bM(9, this.thumbHeight);
      int n = g.a.a.b.b.a.bM(10, this.thumbWidth);
      AppMethodBeat.o(127175);
      return i + paramInt + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Uii.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.KeY == null)
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
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      eeg localeeg = (eeg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127175);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          esh localesh = new esh();
          if ((localObject != null) && (localObject.length > 0)) {
            localesh.parseFrom((byte[])localObject);
          }
          localeeg.Uii.add(localesh);
          paramInt += 1;
        }
        AppMethodBeat.o(127175);
        return 0;
      case 2: 
        localeeg.KeY = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 3: 
        localeeg.md5 = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 4: 
        localeeg.aesKey = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 5: 
        localeeg.url = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(127175);
        return 0;
      case 6: 
        localeeg.lvw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127175);
        return 0;
      case 7: 
        localeeg.mgu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127175);
        return 0;
      case 8: 
        localeeg.SbK = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127175);
        return 0;
      case 9: 
        localeeg.thumbHeight = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127175);
        return 0;
      }
      localeeg.thumbWidth = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(127175);
      return 0;
    }
    AppMethodBeat.o(127175);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeg
 * JD-Core Version:    0.7.0.1
 */