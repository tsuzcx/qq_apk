package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aas
  extends dyl
{
  public String RII;
  public int RSi;
  public String RTS;
  public int SmY;
  public String SmZ;
  public LinkedList<aar> Sna;
  public efo Snb;
  public egs Snc;
  public int scene;
  
  public aas()
  {
    AppMethodBeat.i(124474);
    this.Sna = new LinkedList();
    AppMethodBeat.o(124474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.SmY);
      if (this.SmZ != null) {
        paramVarArgs.f(3, this.SmZ);
      }
      if (this.RTS != null) {
        paramVarArgs.f(4, this.RTS);
      }
      if (this.RII != null) {
        paramVarArgs.f(5, this.RII);
      }
      paramVarArgs.e(6, 8, this.Sna);
      paramVarArgs.aY(7, this.scene);
      paramVarArgs.aY(8, this.RSi);
      if (this.Snb != null)
      {
        paramVarArgs.oE(9, this.Snb.computeSize());
        this.Snb.writeFields(paramVarArgs);
      }
      if (this.Snc != null)
      {
        paramVarArgs.oE(10, this.Snc.computeSize());
        this.Snc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label990;
      }
    }
    label990:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SmY);
      paramInt = i;
      if (this.SmZ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SmZ);
      }
      i = paramInt;
      if (this.RTS != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RTS);
      }
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RII);
      }
      i = paramInt + g.a.a.a.c(6, 8, this.Sna) + g.a.a.b.b.a.bM(7, this.scene) + g.a.a.b.b.a.bM(8, this.RSi);
      paramInt = i;
      if (this.Snb != null) {
        paramInt = i + g.a.a.a.oD(9, this.Snb.computeSize());
      }
      i = paramInt;
      if (this.Snc != null) {
        i = paramInt + g.a.a.a.oD(10, this.Snc.computeSize());
      }
      AppMethodBeat.o(124475);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sna.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aas localaas = (aas)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124475);
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
            localaas.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 2: 
          localaas.SmY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124475);
          return 0;
        case 3: 
          localaas.SmZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 4: 
          localaas.RTS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 5: 
          localaas.RII = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aar();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aar)localObject2).parseFrom((byte[])localObject1);
            }
            localaas.Sna.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 7: 
          localaas.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124475);
          return 0;
        case 8: 
          localaas.RSi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124475);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efo)localObject2).parseFrom((byte[])localObject1);
            }
            localaas.Snb = ((efo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new egs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((egs)localObject2).parseFrom((byte[])localObject1);
          }
          localaas.Snc = ((egs)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      AppMethodBeat.o(124475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aas
 * JD-Core Version:    0.7.0.1
 */