package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bom
  extends com.tencent.mm.cd.a
{
  public String SZt;
  public LinkedList<String> SZx;
  public LinkedList<bon> SZy;
  public int SZz;
  
  public bom()
  {
    AppMethodBeat.i(217039);
    this.SZx = new LinkedList();
    this.SZy = new LinkedList();
    AppMethodBeat.o(217039);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217041);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SZt != null) {
        paramVarArgs.f(1, this.SZt);
      }
      paramVarArgs.e(2, 1, this.SZx);
      paramVarArgs.e(3, 8, this.SZy);
      paramVarArgs.aY(4, this.SZz);
      AppMethodBeat.o(217041);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SZt == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = g.a.a.b.b.a.g(1, this.SZt) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.SZx);
      int j = g.a.a.a.c(3, 8, this.SZy);
      int k = g.a.a.b.b.a.bM(4, this.SZz);
      AppMethodBeat.o(217041);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SZx.clear();
        this.SZy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(217041);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bom localbom = (bom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(217041);
          return -1;
        case 1: 
          localbom.SZt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(217041);
          return 0;
        case 2: 
          localbom.SZx.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(217041);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bon localbon = new bon();
            if ((localObject != null) && (localObject.length > 0)) {
              localbon.parseFrom((byte[])localObject);
            }
            localbom.SZy.add(localbon);
            paramInt += 1;
          }
          AppMethodBeat.o(217041);
          return 0;
        }
        localbom.SZz = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(217041);
        return 0;
      }
      AppMethodBeat.o(217041);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bom
 * JD-Core Version:    0.7.0.1
 */