package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arm
  extends dyl
{
  public aqe RLM;
  public String RLN;
  public int SEA;
  public LinkedList<String> SEB;
  public LinkedList<String> SEC;
  public String SEx;
  public int SEy;
  public LinkedList<String> SEz;
  public String app_id;
  public String description;
  public bdm location;
  public int scene;
  public int xaA;
  public FinderMedia xaz;
  
  public arm()
  {
    AppMethodBeat.i(229442);
    this.SEz = new LinkedList();
    this.SEB = new LinkedList();
    this.SEC = new LinkedList();
    AppMethodBeat.o(229442);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229453);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RLM != null)
      {
        paramVarArgs.oE(2, this.RLM.computeSize());
        this.RLM.writeFields(paramVarArgs);
      }
      if (this.RLN != null) {
        paramVarArgs.f(3, this.RLN);
      }
      if (this.xaz != null)
      {
        paramVarArgs.oE(4, this.xaz.computeSize());
        this.xaz.writeFields(paramVarArgs);
      }
      if (this.description != null) {
        paramVarArgs.f(5, this.description);
      }
      if (this.location != null)
      {
        paramVarArgs.oE(6, this.location.computeSize());
        this.location.writeFields(paramVarArgs);
      }
      if (this.SEx != null) {
        paramVarArgs.f(7, this.SEx);
      }
      if (this.app_id != null) {
        paramVarArgs.f(8, this.app_id);
      }
      paramVarArgs.aY(9, this.scene);
      paramVarArgs.aY(10, this.SEy);
      paramVarArgs.e(11, 1, this.SEz);
      paramVarArgs.aY(12, this.SEA);
      paramVarArgs.aY(13, this.xaA);
      paramVarArgs.e(14, 1, this.SEB);
      paramVarArgs.e(15, 1, this.SEC);
      AppMethodBeat.o(229453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1306;
      }
    }
    label1306:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLM != null) {
        paramInt = i + g.a.a.a.oD(2, this.RLM.computeSize());
      }
      i = paramInt;
      if (this.RLN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RLN);
      }
      paramInt = i;
      if (this.xaz != null) {
        paramInt = i + g.a.a.a.oD(4, this.xaz.computeSize());
      }
      i = paramInt;
      if (this.description != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.description);
      }
      paramInt = i;
      if (this.location != null) {
        paramInt = i + g.a.a.a.oD(6, this.location.computeSize());
      }
      i = paramInt;
      if (this.SEx != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SEx);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.app_id);
      }
      i = g.a.a.b.b.a.bM(9, this.scene);
      int j = g.a.a.b.b.a.bM(10, this.SEy);
      int k = g.a.a.a.c(11, 1, this.SEz);
      int m = g.a.a.b.b.a.bM(12, this.SEA);
      int n = g.a.a.b.b.a.bM(13, this.xaA);
      int i1 = g.a.a.a.c(14, 1, this.SEB);
      int i2 = g.a.a.a.c(15, 1, this.SEC);
      AppMethodBeat.o(229453);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SEz.clear();
        this.SEB.clear();
        this.SEC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        arm localarm = (arm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229453);
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
            localarm.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229453);
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
            localarm.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229453);
          return 0;
        case 3: 
          localarm.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229453);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderMedia();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderMedia)localObject2).parseFrom((byte[])localObject1);
            }
            localarm.xaz = ((FinderMedia)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229453);
          return 0;
        case 5: 
          localarm.description = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229453);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdm)localObject2).parseFrom((byte[])localObject1);
            }
            localarm.location = ((bdm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229453);
          return 0;
        case 7: 
          localarm.SEx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229453);
          return 0;
        case 8: 
          localarm.app_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229453);
          return 0;
        case 9: 
          localarm.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229453);
          return 0;
        case 10: 
          localarm.SEy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229453);
          return 0;
        case 11: 
          localarm.SEz.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(229453);
          return 0;
        case 12: 
          localarm.SEA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229453);
          return 0;
        case 13: 
          localarm.xaA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229453);
          return 0;
        case 14: 
          localarm.SEB.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(229453);
          return 0;
        }
        localarm.SEC.add(((g.a.a.a.a)localObject1).abFh.readString());
        AppMethodBeat.o(229453);
        return 0;
      }
      AppMethodBeat.o(229453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arm
 * JD-Core Version:    0.7.0.1
 */