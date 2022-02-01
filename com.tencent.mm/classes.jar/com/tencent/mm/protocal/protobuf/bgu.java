package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgu
  extends dyl
{
  public FinderObjectDesc SRu;
  public int SRv;
  public String SRw;
  public int scene;
  public String username;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208498);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(2, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.f(3, this.username);
      }
      if (this.SRu != null)
      {
        paramVarArgs.oE(4, this.SRu.computeSize());
        this.SRu.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.SRv);
      if (this.SRw != null) {
        paramVarArgs.f(6, this.SRw);
      }
      paramVarArgs.aY(7, this.scene);
      AppMethodBeat.o(208498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label764;
      }
    }
    label764:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yjp != null) {
        paramInt = i + g.a.a.a.oD(2, this.yjp.computeSize());
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.username);
      }
      paramInt = i;
      if (this.SRu != null) {
        paramInt = i + g.a.a.a.oD(4, this.SRu.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.SRv);
      paramInt = i;
      if (this.SRw != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SRw);
      }
      i = g.a.a.b.b.a.bM(7, this.scene);
      AppMethodBeat.o(208498);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(208498);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgu localbgu = (bgu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(208498);
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
            localbgu.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(208498);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localbgu.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(208498);
          return 0;
        case 3: 
          localbgu.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(208498);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObjectDesc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObjectDesc)localObject2).parseFrom((byte[])localObject1);
            }
            localbgu.SRu = ((FinderObjectDesc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(208498);
          return 0;
        case 5: 
          localbgu.SRv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(208498);
          return 0;
        case 6: 
          localbgu.SRw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(208498);
          return 0;
        }
        localbgu.scene = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208498);
        return 0;
      }
      AppMethodBeat.o(208498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgu
 * JD-Core Version:    0.7.0.1
 */