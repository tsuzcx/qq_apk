package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bgs
  extends dyy
{
  public b SDI;
  public ekk SRq;
  public int SRr;
  public int SRs;
  public String Sae;
  public FinderContact contact;
  public LinkedList<FinderObject> object;
  public int xFI;
  
  public bgs()
  {
    AppMethodBeat.i(206403);
    this.object = new LinkedList();
    AppMethodBeat.o(206403);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206406);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.SDI != null) {
        paramVarArgs.c(3, this.SDI);
      }
      paramVarArgs.aY(4, this.xFI);
      if (this.SRq != null)
      {
        paramVarArgs.oE(5, this.SRq.computeSize());
        this.SRq.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.oE(6, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.Sae != null) {
        paramVarArgs.f(7, this.Sae);
      }
      paramVarArgs.aY(8, this.SRr);
      paramVarArgs.aY(9, this.SRs);
      AppMethodBeat.o(206406);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label934;
      }
    }
    label934:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.SDI != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.SDI);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.xFI);
      paramInt = i;
      if (this.SRq != null) {
        paramInt = i + g.a.a.a.oD(5, this.SRq.computeSize());
      }
      i = paramInt;
      if (this.contact != null) {
        i = paramInt + g.a.a.a.oD(6, this.contact.computeSize());
      }
      paramInt = i;
      if (this.Sae != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Sae);
      }
      i = g.a.a.b.b.a.bM(8, this.SRr);
      int j = g.a.a.b.b.a.bM(9, this.SRs);
      AppMethodBeat.o(206406);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206406);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgs localbgs = (bgs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206406);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbgs.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206406);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbgs.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206406);
          return 0;
        case 3: 
          localbgs.SDI = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(206406);
          return 0;
        case 4: 
          localbgs.xFI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206406);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ekk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ekk)localObject2).parseFrom((byte[])localObject1);
            }
            localbgs.SRq = ((ekk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206406);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbgs.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206406);
          return 0;
        case 7: 
          localbgs.Sae = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206406);
          return 0;
        case 8: 
          localbgs.SRr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206406);
          return 0;
        }
        localbgs.SRs = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(206406);
        return 0;
      }
      AppMethodBeat.o(206406);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgs
 * JD-Core Version:    0.7.0.1
 */