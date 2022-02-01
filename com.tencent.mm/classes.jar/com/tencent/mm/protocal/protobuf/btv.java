package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btv
  extends com.tencent.mm.cd.a
{
  public int RYM;
  public int TcZ;
  public dyi TdO;
  public boolean TdU;
  public boolean TdV;
  public String TdW;
  public int fBP;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175245);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.fBP);
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.f(3, this.md5);
      }
      paramVarArgs.aY(4, this.TcZ);
      paramVarArgs.aY(5, this.RYM);
      paramVarArgs.co(6, this.TdU);
      paramVarArgs.co(7, this.TdV);
      if (this.TdO != null)
      {
        paramVarArgs.oE(20, this.TdO.computeSize());
        this.TdO.writeFields(paramVarArgs);
      }
      if (this.TdW != null) {
        paramVarArgs.f(21, this.TdW);
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.fBP) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.md5);
      }
      i = i + g.a.a.b.b.a.bM(4, this.TcZ) + g.a.a.b.b.a.bM(5, this.RYM) + (g.a.a.b.b.a.gL(6) + 1) + (g.a.a.b.b.a.gL(7) + 1);
      paramInt = i;
      if (this.TdO != null) {
        paramInt = i + g.a.a.a.oD(20, this.TdO.computeSize());
      }
      i = paramInt;
      if (this.TdW != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.TdW);
      }
      AppMethodBeat.o(175245);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      btv localbtv = (btv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        AppMethodBeat.o(175245);
        return -1;
      case 1: 
        localbtv.fBP = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(175245);
        return 0;
      case 2: 
        localbtv.url = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 3: 
        localbtv.md5 = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 4: 
        localbtv.TcZ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(175245);
        return 0;
      case 5: 
        localbtv.RYM = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(175245);
        return 0;
      case 6: 
        localbtv.TdU = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(175245);
        return 0;
      case 7: 
        localbtv.TdV = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(175245);
        return 0;
      case 20: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dyi localdyi = new dyi();
          if ((localObject != null) && (localObject.length > 0)) {
            localdyi.parseFrom((byte[])localObject);
          }
          localbtv.TdO = localdyi;
          paramInt += 1;
        }
        AppMethodBeat.o(175245);
        return 0;
      }
      localbtv.TdW = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(175245);
      return 0;
    }
    AppMethodBeat.o(175245);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btv
 * JD-Core Version:    0.7.0.1
 */