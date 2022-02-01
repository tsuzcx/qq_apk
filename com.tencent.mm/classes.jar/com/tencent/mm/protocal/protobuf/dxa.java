package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dxa
  extends dyl
{
  public aho TeH;
  public LinkedList<all> UcI;
  public long vtu;
  public long vtv;
  
  public dxa()
  {
    AppMethodBeat.i(256261);
    this.UcI = new LinkedList();
    AppMethodBeat.o(256261);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256262);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TeH == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(256262);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.vtu);
      paramVarArgs.bm(3, this.vtv);
      paramVarArgs.e(4, 8, this.UcI);
      if (this.TeH != null)
      {
        paramVarArgs.oE(5, this.TeH.computeSize());
        this.TeH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(256262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label672;
      }
    }
    label672:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.vtu) + g.a.a.b.b.a.p(3, this.vtv) + g.a.a.a.c(4, 8, this.UcI);
      paramInt = i;
      if (this.TeH != null) {
        paramInt = i + g.a.a.a.oD(5, this.TeH.computeSize());
      }
      AppMethodBeat.o(256262);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UcI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TeH == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(256262);
          throw paramVarArgs;
        }
        AppMethodBeat.o(256262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dxa localdxa = (dxa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256262);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localdxa.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(256262);
          return 0;
        case 2: 
          localdxa.vtu = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(256262);
          return 0;
        case 3: 
          localdxa.vtv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(256262);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new all();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((all)localObject2).parseFrom((byte[])localObject1);
            }
            localdxa.UcI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(256262);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aho();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aho)localObject2).parseFrom((byte[])localObject1);
          }
          localdxa.TeH = ((aho)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(256262);
        return 0;
      }
      AppMethodBeat.o(256262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxa
 * JD-Core Version:    0.7.0.1
 */