package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ws
  extends dyl
{
  public String ImS;
  public String SiN;
  public String SiT;
  public String SiU;
  public int SiV;
  public String SiW;
  public String SiX;
  public String SiY;
  public String SiZ;
  public int Sja;
  public int amount;
  public int channel;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72437);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SiT == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_name");
        AppMethodBeat.o(72437);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SiT != null) {
        paramVarArgs.f(2, this.SiT);
      }
      paramVarArgs.aY(3, this.amount);
      if (this.SiU != null) {
        paramVarArgs.f(4, this.SiU);
      }
      if (this.ImS != null) {
        paramVarArgs.f(5, this.ImS);
      }
      paramVarArgs.aY(6, this.SiV);
      paramVarArgs.aY(7, this.channel);
      if (this.SiW != null) {
        paramVarArgs.f(8, this.SiW);
      }
      if (this.SiN != null) {
        paramVarArgs.f(9, this.SiN);
      }
      if (this.SiX != null) {
        paramVarArgs.f(10, this.SiX);
      }
      if (this.SiY != null) {
        paramVarArgs.f(11, this.SiY);
      }
      if (this.SiZ != null) {
        paramVarArgs.f(12, this.SiZ);
      }
      paramVarArgs.aY(13, this.Sja);
      AppMethodBeat.o(72437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1008;
      }
    }
    label1008:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SiT != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SiT);
      }
      i += g.a.a.b.b.a.bM(3, this.amount);
      paramInt = i;
      if (this.SiU != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SiU);
      }
      i = paramInt;
      if (this.ImS != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.ImS);
      }
      i = i + g.a.a.b.b.a.bM(6, this.SiV) + g.a.a.b.b.a.bM(7, this.channel);
      paramInt = i;
      if (this.SiW != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SiW);
      }
      i = paramInt;
      if (this.SiN != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SiN);
      }
      paramInt = i;
      if (this.SiX != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SiX);
      }
      i = paramInt;
      if (this.SiY != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.SiY);
      }
      paramInt = i;
      if (this.SiZ != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.SiZ);
      }
      i = g.a.a.b.b.a.bM(13, this.Sja);
      AppMethodBeat.o(72437);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SiT == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_name");
          AppMethodBeat.o(72437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ws localws = (ws)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72437);
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
            localws.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72437);
          return 0;
        case 2: 
          localws.SiT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 3: 
          localws.amount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72437);
          return 0;
        case 4: 
          localws.SiU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 5: 
          localws.ImS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 6: 
          localws.SiV = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72437);
          return 0;
        case 7: 
          localws.channel = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72437);
          return 0;
        case 8: 
          localws.SiW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 9: 
          localws.SiN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 10: 
          localws.SiX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 11: 
          localws.SiY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 12: 
          localws.SiZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72437);
          return 0;
        }
        localws.Sja = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72437);
        return 0;
      }
      AppMethodBeat.o(72437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ws
 * JD-Core Version:    0.7.0.1
 */