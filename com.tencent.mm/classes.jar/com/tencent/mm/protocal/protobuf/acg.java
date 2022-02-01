package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acg
  extends com.tencent.mm.cd.a
{
  public String SfB;
  public String SfC;
  public long SgR;
  public String SgS;
  public String SgT;
  public chl SnP;
  public String title;
  public String tnY;
  public String tnZ;
  public String ufC;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113985);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.tnY != null) {
        paramVarArgs.f(2, this.tnY);
      }
      if (this.tnZ != null) {
        paramVarArgs.f(3, this.tnZ);
      }
      if (this.url != null) {
        paramVarArgs.f(4, this.url);
      }
      paramVarArgs.bm(5, this.SgR);
      if (this.SgS != null) {
        paramVarArgs.f(6, this.SgS);
      }
      if (this.SgT != null) {
        paramVarArgs.f(7, this.SgT);
      }
      if (this.ufC != null) {
        paramVarArgs.f(8, this.ufC);
      }
      if (this.SnP != null)
      {
        paramVarArgs.oE(9, this.SnP.computeSize());
        this.SnP.writeFields(paramVarArgs);
      }
      if (this.SfB != null) {
        paramVarArgs.f(10, this.SfB);
      }
      if (this.SfC != null) {
        paramVarArgs.f(11, this.SfC);
      }
      AppMethodBeat.o(113985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label884;
      }
    }
    label884:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tnY != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.tnY);
      }
      i = paramInt;
      if (this.tnZ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.tnZ);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.url);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.SgR);
      paramInt = i;
      if (this.SgS != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SgS);
      }
      i = paramInt;
      if (this.SgT != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SgT);
      }
      paramInt = i;
      if (this.ufC != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.ufC);
      }
      i = paramInt;
      if (this.SnP != null) {
        i = paramInt + g.a.a.a.oD(9, this.SnP.computeSize());
      }
      paramInt = i;
      if (this.SfB != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SfB);
      }
      i = paramInt;
      if (this.SfC != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.SfC);
      }
      AppMethodBeat.o(113985);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        acg localacg = (acg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113985);
          return -1;
        case 1: 
          localacg.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 2: 
          localacg.tnY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 3: 
          localacg.tnZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 4: 
          localacg.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 5: 
          localacg.SgR = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(113985);
          return 0;
        case 6: 
          localacg.SgS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 7: 
          localacg.SgT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 8: 
          localacg.ufC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            chl localchl = new chl();
            if ((localObject != null) && (localObject.length > 0)) {
              localchl.parseFrom((byte[])localObject);
            }
            localacg.SnP = localchl;
            paramInt += 1;
          }
          AppMethodBeat.o(113985);
          return 0;
        case 10: 
          localacg.SfB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113985);
          return 0;
        }
        localacg.SfC = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(113985);
        return 0;
      }
      AppMethodBeat.o(113985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acg
 * JD-Core Version:    0.7.0.1
 */