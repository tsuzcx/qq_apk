package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dk
  extends dyl
{
  public String GHy;
  public String OkX;
  public int Olc;
  public String RIU;
  public int day;
  public String fvP;
  public long gbJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91346);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.gbJ);
      if (this.fvP != null) {
        paramVarArgs.f(3, this.fvP);
      }
      if (this.GHy != null) {
        paramVarArgs.f(4, this.GHy);
      }
      if (this.OkX != null) {
        paramVarArgs.f(5, this.OkX);
      }
      paramVarArgs.aY(6, this.day);
      if (this.RIU != null) {
        paramVarArgs.f(7, this.RIU);
      }
      paramVarArgs.aY(8, this.Olc);
      AppMethodBeat.o(91346);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.gbJ);
      paramInt = i;
      if (this.fvP != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fvP);
      }
      i = paramInt;
      if (this.GHy != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.GHy);
      }
      paramInt = i;
      if (this.OkX != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.OkX);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.day);
      paramInt = i;
      if (this.RIU != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RIU);
      }
      i = g.a.a.b.b.a.bM(8, this.Olc);
      AppMethodBeat.o(91346);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91346);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dk localdk = (dk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91346);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdk.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91346);
          return 0;
        case 2: 
          localdk.gbJ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(91346);
          return 0;
        case 3: 
          localdk.fvP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91346);
          return 0;
        case 4: 
          localdk.GHy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91346);
          return 0;
        case 5: 
          localdk.OkX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91346);
          return 0;
        case 6: 
          localdk.day = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91346);
          return 0;
        case 7: 
          localdk.RIU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91346);
          return 0;
        }
        localdk.Olc = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91346);
        return 0;
      }
      AppMethodBeat.o(91346);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dk
 * JD-Core Version:    0.7.0.1
 */